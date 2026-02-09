
package learninheritence;

import learninheritence.device.Mobile;




public class LearnInheritence {

  
    public static void main(String[] args) {
        Mobile m = new Mobile();
        
        m.setBrowser("Chrome");
        m.setIsCall(true);
        m.setIsVideoCall(true);
        m.setOS("Android");
        m.setMusicPlayer("Music Player");
        m.setVideoPlayer("MI Video Player");
        
        System.out.println(m);
        
        
        
        
        
    }
    
}
