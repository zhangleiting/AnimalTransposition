package ch1.view;
import javax.swing.*;
import java.awt.*;
import ch1.data.Animal;
import ch1.data.Point;
import ch1.data.ViewForAnimal;
import ch1.data.LeftAnimal;
import ch1.data.RightAnimal;
import java.util.*;
import java.awt.geom.*; 
public class GamePanel extends JPanel {
    public int animalCount = -1;
    public Point [] point ;
    Animal []  leftAnimal,rightAnimal; 
    public ViewForAnimal [] leftAnimalView,rightAnimalView;//动物视图
    public int width =90,height=70;  //动物视图的大小
    public int gap = 2;              //动物之间的间隙           
    public JButton buttonRedo;//撤销按钮
    public JButton buttonReStart;//重新开始游戏
    public Stack<Point> saveAnimalStep; //存放动物走动的位置，以便恢复
    HandleAnimalMove handleAnimalMove;//负责处理MouseEvent的监视器
    HandleRedo handleRedo;           //负责ActionEvent的监视器 
    HandleReStart handleReStart;    //负责ActionEvent的监视器
    public GamePanel(){
       setLayout(null);
       buttonRedo = new JButton("撤销");
       buttonReStart = new JButton("重新开始");
       saveAnimalStep = new Stack<Point>();
    }
    public void setAnimalCount(int n){
       if(n%2 != 0 ||n<=1) {
          System.out.println(n+"的个数不合理");
          System.exit(0);
       } 
       removeAll();  //首先移出曾添加到该容器中的全部组件
       animalCount = n;
       initPoitAndAnimal();  //初始化动物和位置对象
       initLeftAnimalView(); //初始化左边的动物视图
       initRightAnimalView();
       registerListener();   //注册监视器
    }
    private void initPoitAndAnimal(){//初始化动物和位置对象
       point = new Point[animalCount+1];
       int posionX = width; //点的位置的x坐标
       int posionY = height;
       for(int i=0;i<point.length;i++) {
           point[i] = new Point();
           point[i].setX(posionX);
           point[i].setY(posionY);
           posionX = posionX+width+gap;
       } 
       int m = animalCount/2;
       leftAnimal = new LeftAnimal[m];
       rightAnimal = new RightAnimal[m];
       for(int i =0;i<leftAnimal.length;i++ ){
          leftAnimal[i] = new LeftAnimal();
          leftAnimal[i].setAtPoint(point[i]);
          leftAnimal[i].setAllCanAtPoint(point);
       } 
       for(int i =0;i<rightAnimal.length;i++ ){
          rightAnimal[i] = new RightAnimal();
          rightAnimal[i].setAtPoint(point[m+1+i]);
          rightAnimal[i].setAllCanAtPoint(point);
       }  
    }
    private void initLeftAnimalView(){//初始化左边的动物视图
       int m = animalCount/2;
       leftAnimalView = new ViewForAnimal[m];
       for(int i =0;i<leftAnimalView.length;i++ ){
          leftAnimalView[i] = new AnimalView();
          leftAnimal[i].setAnimalView(leftAnimalView[i]);
          Point p = leftAnimal[i].getAtPoint();
          int x = p.getX();
          int y = p.getY();
          add(leftAnimalView[i]);
          //动物视图所在位置和动物所在点相同：
          leftAnimalView[i].setAnimalViewLocation(x,y);
          leftAnimalView[i].setAnimalViewSize(width,height);
       } 
    }
    private void initRightAnimalView(){//初始化右边的动物视图
       int m = animalCount/2;
       rightAnimalView = new ViewForAnimal[m];
       for(int i =0;i<rightAnimalView.length;i++ ){
          rightAnimalView[i] = new AnimalView();
          rightAnimal[i].setAnimalView(rightAnimalView[i]);
          Point p = rightAnimal[i].getAtPoint();
          int x = p.getX();
          int y = p.getY();
          add(rightAnimalView[i]);
          rightAnimalView[i].setAnimalViewLocation(x,y);
          rightAnimalView[i].setAnimalViewSize(width,height);
       } 
    }
    private void registerListener(){
        handleAnimalMove = new HandleAnimalMove(this);
        //监视用户在动物视图上触发的MouseEvent事件：
        for(int i =0;i<rightAnimalView.length;i++ ){
           rightAnimalView[i].addMouseListener(handleAnimalMove);
        }
        for(int i =0;i<leftAnimalView.length;i++ ){
           leftAnimalView[i].addMouseListener(handleAnimalMove);
        }
        handleRedo = new HandleRedo(this);
        handleReStart = new HandleReStart(this);
        //监视用户在按钮上触发的ActionEvent事件：
        buttonRedo.addActionListener(handleRedo);
        buttonReStart.addActionListener(handleReStart);
    }
    public void setLeftAnimalImage(String pic){
       if(animalCount==-1)
           return;
       for(int i =0;i<leftAnimalView.length;i++ ){
          leftAnimalView[i].setImage(pic);
       } 
    }
    public void setRightAnimalImage(String pic){
       if(animalCount==-1)
           return;
       for(int i =0;i<rightAnimalView.length;i++ ){
          rightAnimalView[i].setImage(pic);
       } 
    }
    public void paintComponent(Graphics g){
       int penHeight =12;  //画笔的高度
       super.paintComponent(g);
       int xStart =width+gap;
       int yStart =2*height+penHeight/2;
       int xEnd =(animalCount+2)*width+(animalCount+1)*2;
       int yEnd =2*height+penHeight/2;
       Line2D line=new Line2D.Double(xStart,yStart,xEnd,yEnd);
       Graphics2D g_2d=(Graphics2D)g;
       g_2d.setColor(Color.blue);
       BasicStroke bs=
       new BasicStroke(penHeight,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
       g_2d.setStroke(bs);
       g_2d.draw(line);
   }
}