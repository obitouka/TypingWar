import greenfoot.*;  
public class Counter extends Actor
{
    int score=0;
    int time=1980;
    Car c;
    public Counter()
    {
       setImage(new GreenfootImage("TIME:"+ --time/60+"\nSPEED OF CAR : "+c.n+" km/h"+"\n SCORE:"+score,35,Color.BLACK,new Color(0,0,20,20)));
    }
    public void act() 
    {
       if(time<0)
       {
            time=0;
       }
       setImage(new GreenfootImage("TIME:"+ --time/60+"\nSPEED OF CAR : "+c.n+" km/h"+"\n SCORE:"+score,35,Color.BLACK,new Color(0,0,20,20)));
       if(time==0)
       {
          MyWorld world = (MyWorld) getWorld();
          world.gameOver(); 
       }
       getScore();
    } 
     public int getScore()
    {
        return score;
    }
}