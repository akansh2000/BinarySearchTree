package com.mycompany.binarysearchtree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.event.*;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import java.io.*;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;
import javafx.scene.*;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.HBox;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;
import javafx.geometry.Insets;
import java.util.Timer;
import javafx.scene.control.ScrollBar; 
import java.util.TimerTask;
import javafx.scene.control.TextArea;
import java.util.Arrays;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.text.FontSmoothingType;



public class App extends Application{

    /**
     * @param args the command line arguments
     */
    
    double x=0.0,y=0.0;
       double x_c=400.0;
       String str=new String();
         circle[] c=new circle[1000];
         int cu=0;
         Node[] arr=new Node[1000];
         StackPane[] s1=new StackPane[1000];
         Pane p=new Pane();
         Label l;
         int j=0;//for stackpane array indexing
         int e=0;// for line array
         TextField t;
         TextField t1;
         double x_par=0;//x coordinate of parent node
         double y_par=0;//y coordinate of the parent node
         TextField t5;
         Button bu3;
         Button b;
         Button b1;
         HBox h1;
         HBox h2;
         HBox h;
         HBox h3;
         Label t3;
         Label t4;
         BorderPane b3;
         
         int i=0;
         int data=0;
         int z=0;
         static Stage PrimaryStage;
         int a=0; // for node array indexing
         Line[] ll=new Line[1000];
         Line l1;
         Label l6;
         int par=-1;
         int vertex=0;
           int flag=0;
           Timer timer;
           TimerTask task;
           String del="";
           String in="";
           String post="";
           String pre="";
           double xx=0.0,yy=0.0;
          
           Label heading;
         class Node 
	{
	       String key;
	       Node left, right;
               double x;
               double y;
               int parent;
               
		public Node(String item)
		{
			key = item;
			left = right = null;
                        
		}
                }
         
         class circle
         {
             double x=0.0;
             double y=0.0;
         }
         
	static Node root;
        
    @Override
    public void start(Stage PrimaryStage)
    {  
        t=new TextField("Enter number");
        t.setStyle("-fx-font-size: 15px;");
        b=new Button("Insert");
        //b.setStyle("-fx-background-color: yellow; ");
        b.setStyle(" -fx-background-color: palegreen; -fx-font-size: 15px; -fx-border-color: teal;");
        t1=new TextField("Enter number");
        t1.setStyle("-fx-font-size: 15px;");
        b1=new Button("Delete");
        b1.setStyle("-fx-background-color: palegreen; -fx-font-size: 15px; -fx-border-color: teal;");
        h1=new HBox(3);
        h1.getChildren().addAll(t,b);
        l6=new Label();
        l6.setPrefWidth(150);
        l6.setMaxWidth(150);
        l6.setStyle("-fx-font-size: 20px;");
        VBox v4=new VBox(20);
        v4.getChildren().addAll(h1,l6);
        h2=new HBox(3);
        h2.getChildren().addAll(t1,b1);
        HBox h7=new HBox(3);
        t5=new TextField("Enter to search");
        bu3=new Button("Search");
        bu3.setStyle("-fx-background-color: palegreen; -fx-border-color: teal;");
        heading=new Label("Binary Search Tree");
        
        heading.setStyle("-fx-text-fill: black;");
        heading.setUnderline(true);
        heading.setFont(Font.font("Verdana", FontPosture.ITALIC,60));
       
        
        
        p.setBackground(new Background(new BackgroundFill(Color.WHEAT , CornerRadii.EMPTY, Insets.EMPTY)));
        
        HBox h8=new HBox(150);
        
        h7.getChildren().addAll(t5,bu3);
        h7.setPadding(new Insets(5,5,5,5));
        h8.getChildren().addAll(h7,heading);
        h=new HBox(5);
        h.getChildren().addAll(v4,h2,h8);
        h1.setPadding(new Insets(5,5,5,5));
        h2.setPadding(new Insets(5,5,5,5));
   
        t3=new Label("0");
        Label l2=new Label("Height= ");
        l2.setStyle("-fx-font-size: 20px;");
        t3.setPrefWidth(100);
        t3.setMaxWidth(100);
        t3.setStyle("-fx-font-size: 20px;");
        Label l3=new Label("No. of vertices= ");
        t4=new Label("0");
        t4.setPrefWidth(100);
        t4.setMaxWidth(100);
        t4.setStyle("-fx-font-size: 20px;");
        l3.setStyle("-fx-font-size: 20px;");
        HBox h5=new HBox(2);
        HBox h4=new HBox(2);
        h4.getChildren().addAll(l2,t3);
        h4.setPadding(new Insets(5,5,5,5));
        h5.getChildren().addAll(l3,t4);
        h5.setPadding(new Insets(5,5,5,5));
        
        HBox h6=new HBox(5);
        h6.getChildren().addAll(h4,h5);
        
         Button print=new Button("          PRINT          ");
         print.setStyle("-fx-background-color: thistle; -fx-border-color: black;");
        Label la=new Label("INORDER TRAVERSAL");
        la.setStyle("-fx-text-fill: teal;");
        Label lb=new Label("PRE-ORDER TRAVERSAL");
        lb.setStyle("-fx-text-fill: purple;");
        Label lc=new Label("POST-ORDER TRAVERSAL");
        lc.setStyle("-fx-text-fill: olive;");
        TextArea textbox1=new TextArea();//FOR INORDER
        textbox1.setWrapText(true);
        textbox1.setPrefColumnCount(20);
        textbox1.setPrefRowCount(5);
        TextArea textbox2=new TextArea();//FOR PRE-ORDER
        textbox2.setWrapText(true);
        textbox2.setPrefColumnCount(20);
        textbox2.setPrefRowCount(5);
        TextArea textbox3=new TextArea();//FOR POST ORDER
        textbox3.setWrapText(true);
        textbox3.setPrefColumnCount(20);
        textbox3.setPrefRowCount(5);
        textbox1.setStyle("-fx-text-fill: green;");
        textbox2.setStyle("-fx-text-fill: blue;");
        textbox3.setStyle("-fx-text-fill: darkmagenta;");
        Button sort=new Button("    SORTED LIST   ");
        sort.setStyle("-fx-background-color: thistle; -fx-border-color: black;");
        Label sor=new Label("SORTED TREE");
        sor.setStyle("-fx-text-fill: royalblue;");
        TextArea textbox_1=new TextArea();//FOR INORDER
        textbox_1.setWrapText(true);
        textbox_1.setPrefColumnCount(20);
        textbox_1.setPrefRowCount(5);
         VBox vr=new VBox(10);
        vr.getChildren().addAll(print,la,textbox1,lb,textbox2,lc,textbox3,sor,textbox_1,sort);//VBOX FOR RIGHT SIDE PRINT  
        b3=new BorderPane();
        VBox v = new VBox(10);
         b3.setTop(h);
         h.setAlignment(Pos.TOP_LEFT);
         b3.setCenter(p);
         b3.setBottom(h6);
         b3.setRight(vr);
        
         b.setOnAction(e->{
            if(arr==null)
            {
                i=0;
                a=0;
            }
            
            insert(t.getText());

            t4.setText(Integer.toString(count(root)));
            
        });
        
       b1.setOnAction(e->{
            deleteKey(Integer.parseInt(t1.getText()));
            delete(t1.getText());
            
        });
        
       bu3.setOnAction(e->{
            String s=t5.getText();
            for(int vx=0;vx<arr.length;vx++)
            {
                if(arr[vx]!=null)
                {
                    if(Integer.parseInt(arr[vx].key)==Integer.parseInt(s))
                    {
                         Circle c8=new Circle();
                          c8.setRadius(25);
                              c8.setFill(Color.TRANSPARENT);
                              c8.setStroke(Color.GREEN);
                              c8.setCenterX(c[vx].x+20.5);
                              c8.setCenterY(c[vx].y+20.5);
                              p.getChildren().add(c8);
                              l6.setStyle("-fx-text-fill: green;");
                              l6.setText(s+" is present");
                              timer=new Timer();
                              task=new TimerTask()
                        {
                            public void run()
                            {
                             c8.setFill(Color.TRANSPARENT);
                              c8.setStroke(Color.TRANSPARENT);
                              c8.setStrokeWidth(30);
                            }
                            };
                         timer.schedule(task,2500l);
                          ++flag;
                        break;
                    }
                    }
            }
            if(flag==0)
            {
                l6.setStyle("-fx-text-fill: red;");
                        l6.setText(s+" is not present");
                        
            }
            flag=0;
            
        });
        
        print.setOnAction(e->{
            inorder();
            textbox1.setText(in);
            postorder();
            textbox3.setText(post);
            preorder();
            textbox2.setText(pre);
        });
        
        
        sort.setOnAction(e->{
            
            str = print_sorted(arr);
            textbox_1.setText(str);
             });
        
        Scene scene=new Scene(b3,500,500);
        PrimaryStage.setScene(scene);
        PrimaryStage.setMaximized(true);
        PrimaryStage.setTitle("Binary Search Tree");
        PrimaryStage.show();
    }
    
    void insert(String key) 
	{ 
            int g=0;
            
            for(int m=0;m<arr.length;m++)
            {
                if(arr[m]!=null)
                {
                    if(Integer.parseInt(arr[m].key)==Integer.parseInt(key))
                    {
                        ++g;
                        break;
                    }
                    
                }
            }
            if(g==0)
            
            {
            for(int m=0;m<s1.length;m++)
            {
                if(s1[m]!=null)
                p.getChildren().removeAll(s1);
                if(m<ll.length&&ll[m]!=null)
                {      
             p.getChildren().removeAll(ll);
                }
            
            
            }
            boolean ctr=false;
		root = insertRec(root, key);
                
                s1[a]=new StackPane();
                arr[a]=new Node(key);
        findParent(root,arr[a],-1);
        int curr_parent=arr[a].parent;
        
        l=new Label(key);
        
      if(i==0)
       {
           
           xx=700;
           yy=10;
    
       }
     else
       {
           
           for(int q=0;q<arr.length;q++){
               if(arr[q]!=null){
                   if(arr[q].parent == curr_parent&&Integer.parseInt(arr[q].key)!=Integer.parseInt(key)){
                       ctr=true;
                       
                       if(Integer.parseInt(arr[q].key) > Integer.parseInt(key)){
                           
                            yy=c[q].y;
                            xx=c[q].x-2*x_c;
                          
                            
                       }
                       else{
                             yy=c[q].y;
                            xx=c[q].x+2*x_c;
                         
                       }
                       break;
                   }
                 
               }
           }
           if(ctr==false)
           {
               Node m=arr[a];
               for(int z=0;z<arr.length;z++)
               {
                   if(arr[z]!=null)
                   {
                       if(m.parent==Integer.parseInt(arr[z].key))
                       {
                           
                          
                           yy=c[z].y+80;
                           if(yy!=250.0)
                           x_c=x_c/1.5;
                           else
                               x_c=x_c/1.2;
                           if(Integer.parseInt(m.key)>m.parent)
                           {
                               xx=c[z].x+x_c;
                           }
                           else
                               xx=c[z].x-x_c;
               
                       }
                   }
               }
            
           }
           
            
       }
      
    c[a]=new circle();  
        Circle c1=new Circle();
         c1.setStroke(Color.BLACK);
        c1.setFill(Color.AQUA);
        c1.setRadius(20.0);
         s1[a].getChildren().addAll(c1,l);
           s1[a].setLayoutX(xx);
           s1[a].setLayoutY(yy);
           c[a].x=xx;
           c[a].y=yy;    
           for(int q=0;q<arr.length;q++)
      {
          if(arr[q]!=null&&c[q]!=null)
          {
              if(Integer.parseInt(arr[q].key)==arr[a].parent)
              {
                  ll[a]=new Line(c[q].x+25,c[q].y+30,xx+9,yy+9);
                  ll[a].setStroke(Color.BLACK);
              }
          }
      }
 for(int m=0;m<ll.length;m++)
           {
               if(ll[m]!=null)
               {
                   p.getChildren().add(ll[m]);
               }
           }
           for(int m=0;m<s1.length;m++)
           {
               if(s1[m]!=null)
               {
                   p.getChildren().add(s1[m]);
               }
  
           }
           
           
           
         a++;
      i++;
	}
            
            else
            {
               l6.setStyle("-fx-text-fill: red;");
                l6.setText(key+" already present");
            
            }
            }
     Node insertRec(Node root, String key)
	{

	if (root == null) 
		{
			root = new Node(key);
                        t3.setText(Integer.toString(maxDepth(root)-1));
                       
			return root;
		}

		
		if (Integer.parseInt(key) <= Integer.parseInt(root.key))
			root.left = insertRec(root.left, key);
		else if (Integer.parseInt(key) > Integer.parseInt(root.key))
			root.right = insertRec(root.right, key);

		
              t3.setText(Integer.toString(maxDepth(root)-1));
         
		return root;
	}
    
    
        void findParent(Node node,Node val, int parent)
{
    if (node == null)
        return;

    if (Integer.parseInt(node.key) == Integer.parseInt(val.key)) 
    {
        val.parent=parent;
        for(int p=0;p<arr.length;p++)
        {
        if(arr[p]!=null)
        {
            if(Integer.parseInt(arr[p].key)==parent)
            {
                if(parent<Integer.parseInt(val.key))
                    arr[p].right=val;
                else
                    arr[p].left=val;
            }
        }
        }
    }
    else
    {

        findParent(node.left, val, Integer.parseInt(node.key));
        findParent(node.right, val, Integer.parseInt(node.key));
    }
 
}
        
        void deleteKey(int key) 
        { 
            root = deleteRec(root, key);
            t3.setText(Integer.toString(maxDepth(root)-1));
           
                      t4.setText(Integer.toString(count(root)));
        }
            
    Node deleteRec(Node root, int key)
    {
        if (root == null)
            return root;
 
        if (key < Integer.parseInt(root.key))
            root.left = deleteRec(root.left, key);
        else if (key > Integer.parseInt(root.key))
            root.right = deleteRec(root.right, key);
 
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = Integer.toString(minValue(root.right));
            del=root.key;
 
            root.right = deleteRec(root.right, Integer.parseInt(root.key));
        }
 
        
        return root;
    }
 
    int minValue(Node root)
    {
        int minv = Integer.parseInt(root.key);
        while (root.left != null) 
        {
            minv = Integer.parseInt(root.left.key);
            root = root.left;
        }
        return minv;
    }
       
       void delete(String key)
       {
           deleteNode(root,key);
       }
       
       void deleteNode(Node node,String key)
       {
           int g=0;
            
            for(int m=0;m<arr.length;m++)
            {
                if(arr[m]!=null)
                {
                    if(Integer.parseInt(arr[m].key)==Integer.parseInt(key))
                    {
                        ++g;
                        break;
                    }
                    
                }
            }
           
           int f=0;
           double xo=0.0,yo=0.0;
           if(g!=0)
           {
           for(int r=0;r<arr.length;r++)
           {
               if(arr[r]!=null)
               {
                   if(Integer.parseInt(arr[r].key)==Integer.parseInt(key))
                   {
                        for(int m=0;m<s1.length;m++)
                          {
                           if(s1[m]!=null)
                           p.getChildren().removeAll(s1);
                           if(m<ll.length&&ll[m]!=null)
                            {      
                                 p.getChildren().removeAll(ll);
                            }
            
            
                          }
                       l6.setStyle("-fx-text-fill: green;");
                       l6.setText(key+" is deleted");
                       f++;
                       if(arr[r].left==null&&arr[r].right==null&&c[r]!=null)
                       {
       
                           for(int m=0;m<arr.length;m++)
                           {
                               if(arr[m]!=null)
                               {
                                   if(Integer.parseInt(arr[m].key)==Integer.parseInt(key))
                                   {
                                       arr[m]=null;
                                       s1[m]=null;
                                       ll[m]=null;
                                   }
                               }
                               
                           }
                           for(int p2=0;p2<arr.length;p2++)
                           {
                               if(arr[p2]!=null)
                               {
                                   if(arr[p2].left!=null&&(Integer.parseInt(arr[p2].left.key)==Integer.parseInt(key))&&(c[p2]!=null))
                                   {
                                       arr[p2].left=null;
                         
                                   }
                                   else if(arr[p2].right!=null&&(Integer.parseInt(arr[p2].right.key)==Integer.parseInt(key)))
                                   {
                              
                                       arr[p2].right=null;
                                    
                                   }
                               }
                           }

                           c[r]=null;   
                       }
                       
                      else if(arr[r].left==null&&arr[r].right!=null)
                       {
                          
                           for(int m=0;m<arr.length;m++)
                           {
                               if(arr[m]!=null)
                               {
                                   if(Integer.parseInt(arr[m].key)==Integer.parseInt(key))
                                   {
                                       
                                       for(int q=0;q<arr.length;q++)
                                       {
                                           if(arr[q]!=null)
                                           {
                                               if(Integer.parseInt(arr[q].key)==Integer.parseInt(arr[r].right.key))
                                               {
                                                   ll[q]=null;
                                                   s1[q]=null;
                                                   c[q].x=c[m].x;
                                                   c[q].y=c[m].y;
                                               }
                                           }
                                       }
                                       
                                       p.getChildren().remove(s1[m]);
                                       s1[m]=new StackPane();
                                       s1[m].setLayoutX(c[m].x);
                                       s1[m].setLayoutY(c[m].y);
                                       l=new Label(arr[r].right.key);
                                       xo=c[m].x;
                                       yo=c[m].y;
                                       c[m]=new circle();  
                                        Circle c1=new Circle();
                                        c1.setStroke(Color.BLACK);
                                        c1.setFill(Color.AQUA);
                                        c1.setRadius(20.0);
                                        s1[m].getChildren().addAll(c1,l);
                                       
                                       
                                   }
                                   
                               }
                           }
                           
                           
                          for(int p=0;p<arr.length;p++)
                          {
                              if(arr[p]!=null)
                              {
                                  if(arr[p].left!=null&&(Integer.parseInt(arr[p].left.key)==Integer.parseInt(arr[r].key)))
                                  {
                                      arr[p].left=arr[p].left.right;
                                      break;
                                  }
                                  else if(arr[p].right!=null&&(Integer.parseInt(arr[p].right.key)==Integer.parseInt(arr[r].key)))
                                  {
                                      arr[p].right=arr[p].right.right;
                                      break;
                                  }
                              }
                          }
                          
                          for(int c=0;c<arr.length;c++)
                          {
                              if(arr[c]!=null)
                              {
                                  if(Integer.parseInt(arr[c].key)==Integer.parseInt(arr[r].right.key))
                                  {
                                     
                                      arr[r].key=arr[c].key;
                                      arr[r].left=arr[c].left;
                                      arr[r].right=arr[c].right;
                                     
                                      arr[c]=null;    
                                      break;
                                  }
                              }
                          }
                          


                       }
                       
                       else if(arr[r].left!=null&&arr[r].right==null)
                       {
                           for(int m=0;m<arr.length;m++)
                           {
                               if(arr[m]!=null)
                               {
                                   if(Integer.parseInt(arr[m].key)==Integer.parseInt(key))
                                   {
                                      
                                       
                                       for(int q=0;q<arr.length;q++)
                                       {
                                           if(arr[q]!=null)
                                           {
                                               if(Integer.parseInt(arr[q].key)==Integer.parseInt(arr[r].left.key))
                                               {
                                                   ll[q]=null;
                                                   s1[q]=null;
                                                   c[q].x=c[m].x;
                                                   c[q].y=c[m].y;
                                               }
                                           }
                                       }
                                        p.getChildren().remove(s1[m]);
                                       s1[m]=new StackPane();
                                       s1[m].setLayoutX(c[m].x);
                                       s1[m].setLayoutY(c[m].y);
                                       l=new Label(arr[r].left.key);
                                       xo=c[m].x;
                                       yo=c[m].y;
                                       c[m]=new circle();  
                                        Circle c1=new Circle();
                                        c1.setStroke(Color.BLACK);
                                        c1.setFill(Color.AQUA);
                                        c1.setRadius(20.0);
                                        s1[m].getChildren().addAll(c1,l);
                                        c[m].x=xo;
                                        c[m].y=yo;
                                       
                                   }
                                   
                               }
                           }
                          
                          for(int p=0;p<arr.length;p++)
                          {
                              if(arr[p]!=null)
                              {
                                  if(arr[p].left!=null&&(Integer.parseInt(arr[p].left.key)==Integer.parseInt(arr[r].key)))
                                  {
                                      arr[p].left=arr[r].left;
                                      break;
                                  }
                                  else if(arr[p].right!=null&&(Integer.parseInt(arr[p].right.key)==Integer.parseInt(arr[r].key)))
                                  {
                                      arr[p].right=arr[r].left;
                                      break;
                                  }
                              }
                          }
                          
                          for(int c=0;c<arr.length;c++)
                          {
                              if(arr[c]!=null)
                              {
                                  if(Integer.parseInt(arr[c].key)==Integer.parseInt(arr[r].left.key))
                                  {
                                      arr[r].key=arr[c].key;
                                      arr[r].left=arr[c].left;
                                      arr[r].right=arr[c].right;
                                      arr[c]=null;
                                      break;
                                  }
                              }
                          }
                         
                       }
                       
                    
                        else if(arr[r].left!=null&&arr[r].right!=null)
                        {
                            
                            for(int q=0;q<arr.length;q++)
                            {
                                if(arr[q]!=null)
                                {
                                    if(Integer.parseInt(arr[q].key)==Integer.parseInt(arr[r].key))
                                    {
                                      p.getChildren().remove(s1[q]);
                                      s1[q]=null;
                                       s1[q]=new StackPane();
                                       s1[q].setLayoutX(c[q].x);
                                       s1[q].setLayoutY(c[q].y);
                                       l=new Label(del);
                                        Circle c1=new Circle();
                                        c1.setStroke(Color.BLACK);
                                        c1.setFill(Color.AQUA);
                                        c1.setRadius(20.0);
                                        s1[q].getChildren().addAll(c1,l);
                                        
                                    }
                                }
                            }
                                for(int q=0;q<arr.length;q++)
                                {
                                if(arr[q]!=null)
                                {
                                 if(Integer.parseInt(arr[q].key)==Integer.parseInt(del))
                                {
                                s1[q]=null;
                                ll[q]=null;
                                //c[r].x=c[q].x;
                                //c[r].y=c[q].y;
                                c[q]=null;
                                
                                
                                            for(int p=0;p<arr.length;p++)
                                              {
                                                if(arr[p]!=null)
                                                {
                                                   if(arr[p].left!=null&&(Integer.parseInt(arr[p].left.key)==Integer.parseInt(arr[r].key)))
                                                     {
                                                     arr[p].left=arr[q];
                                                     //arr[q]=null;
                                                         break;
                                                      }
                                                       else if(arr[p].right!=null&&(Integer.parseInt(arr[p].right.key)==Integer.parseInt(arr[r].key)))
                                                      {
                                                      arr[p].right=arr[q];
                                                      //arr[q]=null;
                                                        break;
                                                       }
                                                      }
                                                     }
                                                     
                                            arr[q]=null;
                                    
                                                    }
                           
                                }
                                //c[r].x=c[q].x;
                                //c[r].y=c[q].y;
                                
                                }
                                
                                if(arr[r].left.key.equalsIgnoreCase(del))
                                  {
                                    
                                       arr[r].left=null;       
                                  }
                        else if(arr[r].right.key.equalsIgnoreCase(del))
                        {
                            arr[r].right=null;
                        }
                        arr[r].key=del;
                        
                   }
                        
                                     for(int m=0;m<s1.length;m++)
           {
               if(s1[m]!=null)
               {
                   p.getChildren().add(s1[m]);
               }
               
           }
           
            for(int m=0;m<ll.length;m++)
           {
               if(ll[m]!=null)
               {
                   p.getChildren().add(ll[m]);
               }
           }
                   
               }
           }
           
           
           }
           }
           else
           {
               l6.setStyle("-fx-text-fill: red;");
               l6.setText(key+" is not present");
               
           }
       
       }
        
         int maxDepth(Node node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            
            int lDepth = maxDepth(node.left); 
            int rDepth = maxDepth(node.right); 
            
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    } 
        
        
        void inorder()  
    {  
         in="";
         inorderRec(root);  
    } 
  

    void inorderRec(Node root) 
    { 
        if (root != null) { 
            inorderRec(root.left); 
            in=in+' '+root.key;
            inorderRec(root.right); 
        } 
    } 
    
    void postorder()
    {
        post="";
        printPostorder(root);
    }
    void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
        printPostorder(node.left); 
        printPostorder(node.right); 
        post+=' '+node.key; 
    } 
      
    void preorder()
    {
       pre="";
       printPreorder(root);
    }
    
    void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
        pre+=' '+node.key; 
        printPreorder(node.left); 
        printPreorder(node.right); 
    } 
    
    int count(Node root)
{
    int c =  1;             //Node itself should be counted
    if (root ==null)
        return 0;
    else
    {
        c += count(root.left);
        c += count(root.right);
        return c;
    }
}
    
    String print_sorted(Node[] arr){
       String str=null;
       int t=0;
       int num[]=new int[1000];
        for(int c=0;c<arr.length;c++){
            if(arr[c]!=null){
            num[t++]=Integer.parseInt(arr[c].key);
            
        }}
        
        Arrays.sort(num);
        for(int w=0;w<num.length;w++){
          if(num[w] !=0){
              str=str+num[w]+" " ;
          } }
        return str.substring(4);
        
}
    
    public static void main(String[] args) {
         root = null; 
        launch(args);
    }
    
}


