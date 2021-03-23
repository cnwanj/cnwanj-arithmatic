# 一、git分别提交到master分支和dev分支

### 1.推送到master分支

初始化：git init

![image-20210323215939480](upload/image-20210323215939480.png)

添加到本地暂存区：git add .

![image-20210323215957629](upload/image-20210323215957629.png)

添加备注：git commit -m "备注"

![image-20210323220015764](upload/image-20210323220015764.png)

本地与远程关联：git remote add origin https://gitee.com/cnwanj/springcloud-config.git

![image-20210323220038823](upload/image-20210323220038823.png)

推送到远程master分支：git push -u origin master

![image-20210323220113539](upload/image-20210323220113539.png)

==注意：若发生如下报错==

![image-20210323222746357](upload/image-20210323222746357.png)

可以开启gitee中的邮箱权限，把打勾去掉如下：

![image-20210323222905606](upload/image-20210323222905606.png)

### 2.推送到dev分支

新建本地分支：git checkout -b dev

![image-20210323220956236](upload/image-20210323220956236.png)

新建后会自动切换到分支，也可以切换分支如下：git checkout dev

添加到本地暂存区：git add .

![image-20210323221043595](upload/image-20210323221043595.png)

查看git操作状态：git status

添加备注：git commit -m "备注"

![image-20210323221052926](upload/image-20210323221052926.png)

推送到远程dev分支：git push -u origin dev

![image-20210323221118685](upload/image-20210323221118685.png)

#### master分支：

![image-20210323221319173](upload/image-20210323221319173.png)

#### dev分支：

![image-20210323221358539](upload/image-20210323221358539.png)