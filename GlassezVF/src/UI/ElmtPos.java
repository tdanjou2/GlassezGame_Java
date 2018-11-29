package UI;

public class ElmtPos {
	
	// Cf. rapport final pour schémas et dessins
	
	public static final double R = 40;
    public static final double r =  R*(Math.cos(Math.PI/6));
    
	public static final double ax = r-r*Math.sin(Math.PI/6);
	public static final double ay = R-(r/2)*Math.tan(Math.PI/3);
	
	public static final double bx = r;
	public static final double by = 0;
	
	public static final double cx = r + r * Math.sin(Math.PI/6);
	public static final double cy = R-((r/2)*Math.tan(Math.PI/3));
	
	public static final double dx = 2*r;
	public static final double dy = R - (r * Math.tan(Math.PI/6));
	
	public static final double ex = 2*r;
	public static final double ey = R;
	
	public static final double fx = 2*r;
	public static final double fy = R+(r*Math.tan(Math.PI/6));
	
	public static final double gx = r + r * Math.sin(Math.PI/6)	;
	public static final double gy = R + ((r/2) * Math.tan(Math.PI/3));
	
	public static final double hx = r;
	public static final double hy = 2*R;
	
	public static final double ix = r - (r * Math.sin(Math.PI/6));
	public static final double iy = R + ((r/2) * Math.tan(Math.PI/3));
	
	public static final double jx = 0;
	public static final double jy = R + (r * Math.tan(Math.PI/6));
	
	public static final double kx = 0;
	public static final double ky = R;
	
	public static final double lx = 0;
	public static final double ly = R - (r * Math.tan(Math.PI/6));
	
	public static final double mx = r;
	public static final double my = R;

}