public class follower implements Observer{
    private String followerName;

    public follower(String name){
        this.followerName = name;
    }

    @Override
    public void update(String s){
        System.out.println("The channel you are following is now" + s);
        play();
    }

    public void play(){
        System.out.println("Video is being played on" + followerName + "'s device");
    }

    public static void main(String[] args){
        Channel c1 = new Channel("Pewdipie");

        follower f1 = new follower("follower_1");
        follower f2 = new follower("follower_2");
        follower f3 = new follower("follower_3");
        c1.registerObserver(f1);
        c1.registerObserver(f2);
        c1.registerObserver(f3);

        c1.setStatus("playing COD COLD WAR");

        c1.unregisterObserver(f2);

        c1.setStatus("playing Minecraft");
    }
}
