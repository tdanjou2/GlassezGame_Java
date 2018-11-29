package Logique;

import UI.ElmtPos;

public enum Orientation {
	
	// Une orientation est caractérisée par 4 points
	
	
	A(new double[] {ElmtPos.kx, ElmtPos.lx, ElmtPos.ax, ElmtPos.mx}, 
	  new double[] {ElmtPos.ky, ElmtPos.ly, ElmtPos.ay, ElmtPos.my},
	  ElmtPos.R,
	  ElmtPos.r),
	
	B(new double[] {ElmtPos.ax, ElmtPos.bx, ElmtPos.cx, ElmtPos.mx},
	  new double[] {ElmtPos.ay, ElmtPos.by, ElmtPos.cy, ElmtPos.my},
	  ElmtPos.R,
	  ElmtPos.r),
	
	C(new double[] {ElmtPos.cx, ElmtPos.dx, ElmtPos.ex, ElmtPos.mx},
	  new double[] {ElmtPos.cy, ElmtPos.dy, ElmtPos.ey, ElmtPos.my},
	  ElmtPos.R,
	  ElmtPos.r),
	
	D(new double[] {ElmtPos.ex, ElmtPos.fx, ElmtPos.gx, ElmtPos.mx},
	  new double[] {ElmtPos.ey, ElmtPos.fy, ElmtPos.gy, ElmtPos.my},
	  ElmtPos.R,
	  ElmtPos.r),

	E(new double[] {ElmtPos.gx, ElmtPos.hx, ElmtPos.ix, ElmtPos.mx},
	  new double[] {ElmtPos.gy, ElmtPos.hy, ElmtPos.iy, ElmtPos.my},
	  ElmtPos.R,
	  ElmtPos.r),
	
	F(new double[] {ElmtPos.ix, ElmtPos.jx, ElmtPos.kx, ElmtPos.mx},
	  new double[] {ElmtPos.iy, ElmtPos.jy, ElmtPos.ky, ElmtPos.my},	
	  ElmtPos.R,
	  ElmtPos.r);

	private final double [] xCoords;
	private final double [] yCoords;
	private final double R;
	private final double r;
	
	// Le constructeur de l'objet Orientation
	Orientation(double[] xCoords, double[] yCoords, double R, double r){
		
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.R = R;
		this.r = r;
	}

	public double[] getxCoords() {
		return xCoords;
	}

	public double[] getyCoords() {
		return yCoords;
	} 	
	
	public double getR() {
		return R;
	}
	
	public double getr() {
		return r;
	}
}


