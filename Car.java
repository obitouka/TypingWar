import greenfoot.*;  
public class Car extends Actor
{
    int time=1980;
    static int n=1;
    int count=0;
    Counter counter;
    int timer;
    Message message;
    public Car()
    {
         
    }
    public void act()
    {
    time--;
    if(time<1860)
     {
        move(n);
         if(++count % 335==0)
        {
          n++;
        }
     }
    if(isTouching(End.class) && ++timer>10)
      {
          MyWorld world1 = (MyWorld) getWorld();
          world1.touch();
      }
    }
}