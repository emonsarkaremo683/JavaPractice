
package learninheritence.device;


public class Mobile extends Device{
    
    private String OS;
    private boolean isCall;
    private boolean isVideoCall;

    public Mobile(String OS, boolean isCall, boolean isVideoCall) {
        this.OS = OS;
        this.isCall = isCall;
        this.isVideoCall = isVideoCall;
    }

    public Mobile(String OS, boolean isCall, boolean isVideoCall, String videoPlayer, String musicPlayer, String browser) {
        super(videoPlayer, musicPlayer, browser);
        this.OS = OS;
        this.isCall = isCall;
        this.isVideoCall = isVideoCall;
    }

    public Mobile() {
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public boolean isIsCall() {
        return isCall;
    }

    public void setIsCall(boolean isCall) {
        this.isCall = isCall;
    }

    public boolean isIsVideoCall() {
        return isVideoCall;
    }

    public void setIsVideoCall(boolean isVideoCall) {
        this.isVideoCall = isVideoCall;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Mobile{" + "OS=" + OS + ", isCall=" + isCall + ", isVideoCall=" + isVideoCall + '}';
    }
    
    
     
}
