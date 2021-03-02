# 一、动态加载Fragment

在Activity中点击按钮来动态显示两个Fragment。

1.在activity_main.xml引入要加载的碎片：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:layout_margin="16dp">
        
    	<!--动态加载碎片输入框-->
        <FrameLayout
            android:id="@+id/show_content"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
    </LinearLayout>
</LinearLayout>
```

2.在fragment_a.xml中添加一个按钮：

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    tools:context=".fragment.NextFragment">
    
	<Button
        android:id="@+id/btn_a"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="A按钮"
        android:onClick="aClick"/>
</FrameLayout>
```

3.在fragment_b.xml中添加一个按钮：

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    tools:context=".fragment.NextFragment">
    
	<Button
        android:id="@+id/btn_b"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="B按钮"
        android:onClick="bClick"/>
</FrameLayout>
```

4. AFragment.java如下：

```java
public class AFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}
```

5.BFragment.java如下：

```java
public class BFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}
```

5.在MainActivity.java中处理动态显示的碎片

```java
public class MainActivity extends AppCompatActivity {
 	
    private Fragment aFragment;
    private Fragment bFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        // 实例化要显示的碎片
        aFragment = new AFragment();
        showOrHideFragment(aFragment);
    }   
    
    public void clickNext(View view) {
        switch(view.getId()) {
            case R.id.btn_a:
                if (aFragment == null) {
                    // 若要显示的碎片为null，则实例化
                    aFragment = new AFragment();
                }
                showOrHideFragment(aFragment);
                break;
            case R.id.btn_b:
                if (bFragment == null) {
                    // 若要显示的碎片为null，则实例化
                    bFragment = new BFragment();
                }
                showOrHideFragment(bFragment);
                break;
        }
        // 将当前事务添加到返回栈中，即按下“返回”时，回退上一步的操作
        transaction.addToBackStack(null);
    }

	/**
     * 将碎片添加到事务中，并显示或隐藏碎片
     * @param addFragment   要添加的碎片
     */
    public void showOrHideFragment(Fragment addFragment) {
        // 通过碎片管理器开启事务
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.show_content, addFragment);
        transaction.commit();
    }
}
```

