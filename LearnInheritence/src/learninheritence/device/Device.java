
package learninheritence.device;


public class Device {
    
    private String videoPlayer;
    private String musicPlayer;
    private String browser;

    public Device() {
    }

    public Device(String videoPlayer, String musicPlayer, String browser) {
        this.videoPlayer = videoPlayer;
        this.musicPlayer = musicPlayer;
        this.browser = browser;
    }

    public String getVideoPlayer() {
        return videoPlayer;
    }

    public void setVideoPlayer(String videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    public String getMusicPlayer() {
        return musicPlayer;
    }

    public void setMusicPlayer(String musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Override
    public String toString() {
        return "Device{" + "videoPlayer=" + videoPlayer + ", musicPlayer=" + musicPlayer + ", browser=" + browser + '}';
    }

    public void printInfo(){
        System.out.println("Device{" + "videoPlayer=" + videoPlayer + ", musicPlayer=" + musicPlayer + ", browser=" + browser + '}');
                
    }
    
    
    
    
}
