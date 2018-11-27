import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.*;  
import java.awt.event.*; 
class node
{
Matrix mn;
Shape sn;
int carr[];
node()
{
 mn=new Matrix();
 sn=new Shape();
 carr=new int[29];
int i = 100;
}
	node(Shape sh1,Matrix mn1,Point[] prev,int maxrowcount[])
	{
	mn = new Matrix(mn1.r,mn1.c);
    sn = new Shape();
     carr=new int[30]; 
     
     for(int i=0;i<29;i++)
     {
     carr[i]=maxrowcount[i];
     }
     
    sn.position=sh1.position;
    sn.currentshape=sh1.currentshape;

    for(int j=0;j<4;j++)
		{
		sn.w[j].x=sh1.w[j].x;
		sn.w[j].y=sh1.w[j].y;
		}
		
		for(int i=0;i<mn1.r;i++)
		{
			for(int j=0;j<mn1.c;j++)
			{
			mn.arr[i][j]=mn1.arr[i][j];
			}
		}
		//System.out.println("new node constructor ended");
	}
} 
class Matrix
{
	int r,c;
	char arr[][];
	
	Matrix()
	{
	}
	
	Matrix(int x,int y)
	{
	r=x;
	c=y;
	arr=new char[r][c];
	}
	
	void clearrow(int x)
	{
	for(int j=1;j<c-1;j++)
	arr[x][j]=' ';
	}
	
	void shift(int x)
	{

			for(int i=x-1;i>=1;i--)
			{
					for(int j=1;j<c-1;j++)
					{
						 if(arr[i][j]=='#')
						 {	 
							 arr[i+1][j]='#';
							 arr[i][j]=' ';
						 }
					}
			}

	}
	
	int checkevery(int a, int b,Shape sh)
	{
		for(int k=0;k<4;k++)
		{
			if(sh.w[k].x==a&&sh.w[k].y==b)
			{
			return 1;
			}
		}
		return 0;
	}
	int checkeveryrot(int a, int b,Point[] prev)
	{
		for(int k=0;k<4;k++)
		{
			if(prev[k].x==a&&prev[k].y==b)
			{
			return 1;
			}
		}
		return 0;
	}
	int check(Shape sh)
	{
		for(int k=0;k<4;k++)
		{
			if(arr[sh.w[k].x +1][sh.w[k].y]!=' '||sh.w[k].x==r-2)
			{
				if(checkevery(sh.w[k].x +1,sh.w[k].y,sh)==0)
				return 1;
			}	
		}
		return 0;
	}
	
	int rotcheck(Shape sh,Point[] prev)
	{
		for(int k=0;k<4;k++)
		{
			if(arr[sh.w[k].x][sh.w[k].y]!=' '||sh.w[k].x==r-2||sh.w[k].y==0||sh.w[k].y==c-2)
			{
				if(checkeveryrot(sh.w[k].x,sh.w[k].y,prev)==0)
				return 1;
			}	
		}
		return 0;
	}
	
	int rightcheck(Shape sh)
	{
		for(int k=0;k<4;k++)
		{
			if(arr[sh.w[k].x][sh.w[k].y +1]!=' '||sh.w[k].x==r-2)
			{
				if(checkevery(sh.w[k].x,sh.w[k].y+1,sh)==0)
				return 1;
			}	
		}
		return 0;
	}
	int leftcheck(Shape sh)
	{
		for(int k=0;k<4;k++)
		{
			if(arr[sh.w[k].x][sh.w[k].y -1]!=' '||sh.w[k].x==r-2)
			{
				if(checkevery(sh.w[k].x,sh.w[k].y-1,sh)==0)
				return 1;
			}	
		}
		return 0;
	}
	
		void update(Shape sh,Point[] prev)
		{
		 for(int i=0;i<r;i++)
			{
				for(int j=0;j<c;j++)
				{
					if((i==prev[0].x && j==prev[0].y)||(i==prev[1].x && j==prev[1].y)||(i==prev[2].x &&j==prev[2].y)||(i==prev[3].x && j==prev[3].y))
						{
						arr[i][j]=' ';
						}
						
					 if((i==sh.w[0].x && j==sh.w[0].y)||(i==sh.w[1].x && j==sh.w[1].y)||(i==sh.w[2].x && j==sh.w[2].y)||(i==sh.w[3].x && j==sh.w[3].y))
						{
						arr[i][j]='#';
						}
						
				}
			}
		}
		
	void newupdate(Shape sh)
		{
		 for(int i=0;i<r;i++)
			{
				for(int j=0;j<c;j++)
				{

					 if((i==sh.w[0].x && j==sh.w[0].y)||(i==sh.w[1].x && j==sh.w[1].y)||(i==sh.w[2].x && j==sh.w[2].y)||(i==sh.w[3].x && j==sh.w[3].y))
						{
						arr[i][j]='#';
						}
						
				}
			}
		}
		
		void assign()
		{

			int k=0;
			for(int i=0;i<r;i++)
			{
				for(int j=0;j<c;j++)
				{

						arr[i][j]=' ';
				}
				
			}
			
			for(int i=0;i<r;i++)
			{
			arr[i][0]='@';
			arr[i][c-1]='@';
			}
			for(int i=0;i<c;i++)
			{
			arr[0][i]='@';
			arr[r-1][i]='@';
			}
		}
		void display()
		{	System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
			for(int i=0;i<r;i++)
			{
				for(int j=0;j<c;j++)
				{
				System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}

}

class Point
{
public int x,y;
	void set(int x,int y)
	{
	this.x=x;
	this.y=y;
	}
}
class Shape
{
Point[] w;
String currentshape;
int position=0;
	Shape()
	{
	   currentshape=new String();
	    w = new Point[4];
		
		for(int j=0;j<4;j++)
		w[j]=new Point();
		 
	}
	Shape(int r,int c,Point[] prev,Matrix mat)
	{
		 currentshape=new String();
		
	    Ranshape allshapes[] = Ranshape.values(); 
	    Random rand = new Random();

		int  n = rand.nextInt(3) + 0;
		this.currentshape=allshapes[n].toString();
		create(allshapes[n]);
		
		/*System.out.println("prev is");
		for(int j=0;j<4;j++)
		System.out.println(prev[j].x+" "+prev[j].y);*/
		
		mat.newupdate(this);	 
		mat.display();
	}
	void create(Ranshape ab)
	{
		w = new Point[4];
		
		for(int j=0;j<4;j++)
		w[j]=new Point();
	
		w[0].set(ab.coords[0][0],ab.coords[0][1]);
		w[1].set(ab.coords[1][0],ab.coords[1][1]);
		w[2].set(ab.coords[2][0],ab.coords[2][1]);
		w[3].set(ab.coords[3][0],ab.coords[3][1]);
	}
}
enum Ranshape {
 
  ZShape(new int[][] { { 1, 13 }, { 1, 14 }, { 2, 14 }, { 2, 15 } }),
  LineShape(new int[][] { { 1, 13 }, { 1, 14 }, { 1, 15 }, { 1, 16 } }),
  TShape(new int[][] { { 1, 13 }, { 1, 14 }, { 1, 15 }, { 2, 14 } }),
  SquareShape(new int[][] { { 1, 13 }, { 1, 14 }, { 2, 13 }, { 2, 14 } }),
  LShape(new int[][] { { 1, 13 }, { 2, 13 }, { 3, 13 }, { 3, 14 } }),
  MirroredLShape(new int[][] { { 1, 13 }, { 2, 13 }, { 3, 13 }, { 3, 12 } });
 
  public int[][] coords;
 
 
  private Ranshape(int[][] coords) {
    this.coords = coords;    
  }
}

class Movement
{
	Movement()
	{
	
		
		
	}
	void copy(Point[] prev,Point[] curr)
	{
		for(int j=0;j<4;j++)
		{
		prev[j].x=curr[j].x;
		prev[j].y=curr[j].y;
		}
	}
	void left(Shape sh,int c,Matrix mat,Point[] prev)
	{
	copy(prev,sh.w);
			if(mat.leftcheck(sh)==1)
			{
			mat.update(sh,prev);
			mat.display();
			return;
			}
		for(int k=0;k<4;k++)
		{
		sh.w[k].y=sh.w[k].y-1;
		}

		mat.update(sh,prev);
		mat.display();
		//System.out.println("left ended");
	}
	void right(Shape sh,int c,Matrix mat,Point[] prev)
	{
	copy(prev,sh.w);
			if(mat.rightcheck(sh)==1)
			{
			mat.update(sh,prev);
			mat.display();
			return;
			}
		for(int k=3;k>=0;k--)
		{
		sh.w[k].y=sh.w[k].y+1;
		}
		mat.update(sh,prev);
		mat.display();
		//System.out.println("right ended");
	}
	int down(Shape sh,int r,Matrix mat,Point[] prev)
	{
	   copy(prev,sh.w);
	   
		if(mat.check(sh)==1)
		{
	     copy(sh.w,prev);
	   
			for(int j=0;j<4;j++)
		    {
		     
		     prev[j].set(1,1);
		    }
			mat.update(sh,prev);
		    mat.display();
			return 1;
		}
		for(int k=3;k>=0;k--)
		{
		sh.w[k].x=sh.w[k].x+1;
		}
		mat.update(sh,prev);
		mat.display();
		//System.out.println("down ended");
		return 0;
	}
	
}
enum rot
{
 LineShape(new int[][] { {0,0,1,-1,2,-2,3,-3},{0,0,-1,-1,-2,-2,-3,-3},{0,0,-1,1,-2,2,-3,3},{0,0,1,1,2,2,3,3} }),
 ZShape(new int[][] { { 0,1,1,1,0,0,1,0 }, { 2,-1,0,0,0,0,0,-1 }, {-2,1,0,0,0,0,0,1}, {0,-1,-1,-1,0,0,-1,0 } }),
  TShape(new int[][] { { -1,1,0,0,1,-1,-1,-1 }, {1,1,0,0,-1,-1,-1,1}, {1,-1,0,0,-1,1,1,1}, { -1,-1,0,0,1,1,1,-1 } }),
   SquareShape(new int[][] { { 0,0,0,0,0,0,0,0}, { 0,0,0,0,0,0,0,0}, { 0,0,0,0,0,0,0,0}, { 0,0,0,0,0,0,0,0}}),
   LShape(new int[][] { { 1,1,0,0,-1,-1,0,-2 }, {1,-1,0,0,-1,1,-2,0 }, {0,-1,1,0,2,1,1,2 }, {-2,2,-1,1,0,0,1,1} }),
     MirroredLShape(new int[][] { {2,1,1,0,0,-1,-1,0 }, {0,-1,-1,0,-2,1,-1,2 }, {-1,-1,0,0,1,1,2,0 }, { -1,1,0,0,1,-1,0,-2 } });
 public int[][] rotcoords;

   private rot(int[][] rotcoords)
   {
    this.rotcoords = rotcoords; 
   }
}
class Rotation
{
	Rotation()
	{
		
		
		
	}
	void copy(Point[] prev,Point[] curr)
	{
		for(int j=0;j<4;j++)
		{
		prev[j].x=curr[j].x;
		prev[j].y=curr[j].y;
		}
	}
	void clockwise(Shape sh,Matrix mat,Point [] prev)
	{
	//System.out.println(" hi you are in clockwise rotation");
	String s=sh.currentshape;
	rot xy=rot.valueOf(s);
	int x=sh.position;
	//System.out.println(" shape is in position "+x);
	int i=0;
	copy(prev,sh.w);
	
	    /*for(int j=0;j<4;j++)
		{
			System.out.println("previously sh is" +sh.w[j].x+" "+sh.w[j].y);
		}*/
		
		for(int j=0;j<4;j++)
		{
		sh.w[j].x+=xy.rotcoords[x][i++];
		sh.w[j].y+=xy.rotcoords[x][i++];
		}
		/*for(int j=0;j<4;j++)
		{
			System.out.println("sh is" +sh.w[j].x+" "+sh.w[j].y);
		}*/
		i=0;
		/*for(int j=0;j<4;j++)
		{
			System.out.println("coords are"+xy.rotcoords[x][i++]+" "+xy.rotcoords[x][i++]);
		}*/
		   if(mat.rotcheck(sh,prev)==1)
			{
			copy(sh.w,prev);
			mat.update(sh,prev);
			mat.display();
			return;
			}
			if(sh.position==3)
			sh.position=0;
			else
			sh.position+=1;
			//System.out.println(" shape is in new position "+sh.position);
			mat.update(sh,prev);
			mat.display();
			//System.out.println("clockwise rotation ended");
	}
	
}

 class Tetris
 { 
    static int r=30;
	static int c=30;
	static int[] maxrowcount=new int[29];
	static int[] maxcolcount=new int[29];
	
	public static void main(String args[])
	{
	   new Tetris();  
	Matrix mat=new Matrix(r,c);
	
	Point[] prev = new Point[4];
	 
		
		for(int j=0;j<4;j++)
		{
		prev[j]=new Point();
		prev[j].set(1,1);
		}
			mat.assign();
			mat.display();
			 
			 Stack<node> aryan = new Stack<node>();  
			  Movement mo=new Movement();
			 Rotation ro=new Rotation();	
		 
		while(true)
		{
			int flag=0;
			
			Shape sh=new Shape(r,c,prev,mat);
				   while(flag==0)
					{
					
					    Scanner sc=new Scanner(System.in);
						//System.out.println("Down");
					    flag = mo.down(sh,r,mat,prev);
						char ch = sc.next().charAt(0);
						
						if(ch=='a')
					    mo.left(sh,c,mat,prev);
					
						else if(ch=='d')
						mo.right(sh,c,mat,prev);
						
						else if(ch=='c')
						ro.clockwise(sh,mat,prev);
						
						else if(ch=='u')
						{
						node preksha=aryan.pop();
						//System.out.println("preksha"+preksha.sn.position+" "+preksha.sn.currentshape);
						sh=preksha.sn;
							for(int i=0;i<r;i++)
							{
								for(int j=0;j<c;j++)
								{
								mat.arr[i][j]=preksha.mn.arr[i][j];
								}
				            }
				            for(int i=0;i<29;i++)
							 {
							 maxrowcount[i]=preksha.carr[i];
							 }
     
						}

						if(flag==1)
							{
								for(int j=0;j<4;j++)
								{
									maxrowcount[sh.w[j].x]+=1;
									maxcolcount[sh.w[j].x]+=1;
									
									if(maxrowcount[sh.w[j].x]==28)
									{
									mat.clearrow(sh.w[j].x);
									mat.display();
									mat.shift(sh.w[j].x);
									mat.display();
									maxrowcount[sh.w[j].x]=0;
									}
									
									System.out.println("Hi you are in maxrowcount "+ sh.w[j].x );
								}
							}
						
						node newnode = new node(sh,mat,prev,maxrowcount);
						
                        if(ch!='u')
						aryan.push(newnode);
							
					}
		}
	}
}
