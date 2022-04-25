package org.gxuwz.arithmatic.designPattern.main7_适配器模式;

/**
 * @author: cnwanj
 * @date: 2022-04-21 21:49:17
 * @version: 1.0
 * @desc: 适配器模式（结构型模式）
 */
public class Adapter {
	public static void main(String[] args) {
		MediaPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play("mp3", "beyond.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "gay is a girl.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}
}

/**
 * 媒体播放器接口
 */
interface MediaPlayer {
	void play(String audioType, String fileName);
}

/**
 * 高级媒体播放器接口
 */
interface AdvanceMediaPlayer {

	void playVlc(String fileName);

	void playMp4(String fileName);
}

/**
 * Vlc播放器类
 */
class VlcPlayer implements AdvanceMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println("playVlc: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {

	}
}

/**
 * Mp4播放器类
 */
class Mp4Player implements AdvanceMediaPlayer {

	@Override
	public void playVlc(String fileName) {

	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("playMp4: " + fileName);
	}
}

/**
 * 媒体适配器
 */
class MediaAdapter implements MediaPlayer {

	AdvanceMediaPlayer advanceMediaPlayer;

	public MediaAdapter(String audioType) {
		if ("vlc".equalsIgnoreCase(audioType)) {
			advanceMediaPlayer = new VlcPlayer();
		} else if ("mp4".equalsIgnoreCase(audioType)) {
			advanceMediaPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		if ("vlc".equalsIgnoreCase(audioType)) {
			advanceMediaPlayer.playVlc(fileName);
		} else if ("mp4".equalsIgnoreCase(audioType)) {
			advanceMediaPlayer.playMp4(fileName);
		}
	}
}

/**
 * 音频播放器
 */
class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		// 播放mp3
		if ("mp3".equalsIgnoreCase(audioType)) {
			System.out.println("PlayMp3: " + fileName);
		} else if ("vlc".equalsIgnoreCase(audioType)
			|| "mp4".equalsIgnoreCase(audioType)) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid Media ["
				+ audioType + "] format not supported");
		}
	}
}
