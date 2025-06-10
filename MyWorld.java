import greenfoot.*; 
import java.util.List;
/**
 ************************************************************************
 **     Purpose:- For testing your typing speed within 30 seconds      **
 **     Author:- Roshan123                                             **
 ************************************************************************
 */
public class MyWorld extends World
{
    Counter counter = new Counter();
    GreenfootImage correct=new GreenfootImage("correct.png");
    GreenfootImage incorrect=new GreenfootImage("incorrect.png");
    Actor[] objs = {new A(), new B(), new C(),new D(),new E(),new F(),new G(),new H(),new I()
    ,new J(),new K(),new L(),new M(),new N(),new O(),new P(),new Q(),new R(),new S(),new T()
    ,new U(),new V(),new W(),new X(),new Y(),new Z()};
    int rand,trans=150;
    Message message = new Message();
    int time=1980;
    public Car c=new Car();
    Result result =new Result();
    End end=new End();
    boolean over=false;
    public MyWorld()
    {    
        super(600, 600, 1); 
        Greenfoot.start();
        Greenfoot.setSpeed(50);
        addObject(message, getWidth()/2,55);
        addObject(counter, getWidth()/2, getHeight()-100);
        addObject(c, getWidth()-599, getHeight()-200);
        addObject(end, getWidth(), getHeight()-200);
    }
    
    public void gameOver()
    {
        if(UserInfo.isStorageAvailable()) 
        {
            UserInfo myData = UserInfo.getMyInfo();
            if (myData != null) {
                int newValue = counter.getScore();
                if (newValue > myData.getScore()) {
                    myData.setScore (newValue);
                    myData.store(); 
                }
            }
        } 
        over=true;
        removeObject(message);
        removeObject(result);
        removeObject(objs[rand]);
        removeObject(c);
        removeObject(end);
        addObject(new ScoreBoard(460, 440), getWidth() / 2, getHeight() / 2-100);
        Greenfoot.stop();
    }
    public void act()
    {
      carSpeed();  
      addAndRemove();
      keys();
      randomColor();
      if(over==true)
      {
        removeObject(objs[rand]);
        Greenfoot.stop();
      }
    }
    public void carSpeed()
    {
      if(counter!=null && counter.time>1860)
      {
        c.n=1;       
      }
    }
    public void addAndRemove()
    {
        if(--time<30)
        {
          showText("LOADING \nSCORES...", getWidth()/2, getHeight()-25);
        }
        if(time<0)
        {
            removeObject(counter);
            removeObject(message);
        }
    }
    public void keys()
    {
      String key = Greenfoot.getKey();
      if(trans<255)
      {
         trans+=5;
         result.getImage().setTransparency(trans);
      }
      if(key != null)
         trans=100;
      
      if(key != null && time<1860)
      {
       int n= "abcdefghijklmnopqrstuvwxyz".indexOf(key);
       addObject(result, getWidth() / 2+40, getHeight() / 2);
       if(n==rand)
       {
         result.setImage(correct);
       } 
       
       else if(n!=rand) 
       {
           result.setImage(incorrect);
           result.getImage().setTransparency(trans);
       }
       if(n==rand && time<1860)
       {
           counter.score+=2;
           removeObject(objs[rand]);
           c.move(-220);
           started();
       }
       if(n!=rand && time<1860)
       {
          counter.score-=1;
          c.move(20);
       }
      }   
    }
    
    public void touch()
    {
       if(UserInfo.isStorageAvailable()) 
       {
        UserInfo myData = UserInfo.getMyInfo();
        if (myData != null) 
        {
           int newValue = counter.getScore();
           if (newValue > myData.getScore())
            {
               myData.setScore (newValue);
               myData.store(); 
            }
        }
        over=true;
        removeObject(message);
        removeObject(result);
        removeObject(end);
        removeObject(objs[rand]);
        removeObject(c);
        addObject(new ScoreBoard(460, 440), getWidth() / 2, getHeight() / 2-100);
       }
    }
    public void started()
    {
        rand=Greenfoot.getRandomNumber(objs.length);
        addObject(objs[rand],getWidth() / 2, getHeight() / 2);
    }
    public void randomColor()
    {
       try{
           getBackground().drawRect(c.getX(),c.getY(),10,10);
           getBackground().setColor(Color.DARK_GRAY);
           getBackground().fillRect(c.getX(),c.getY(),9,9);
       }catch(Exception e){}
    } 
}