package backend.models;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;

import javax.imageio.ImageIO;

public class StageObject extends Asset {
	private Image image;
	private String imageRef;
	private String name;
	
	public StageObject(){
		super();
	}
	
	public StageObject(String name, double w, double l, double x, double y, double a, String imageRef) {
		super(w, l, x, y, a);
		File file = new File(imageRef);
		System.out.println(file.getAbsolutePath());
		
		try {
			this.image = ImageIO.read(new File(imageRef));
		} catch (IOException e){
			this.image = null;
		}
		
		this.imageRef = imageRef;
		this.name = name;
	}
	
	public StageObject(String name, double w, double l, String imageRef) {
		this(name, w, l, 0, 0, 0, imageRef);
	}
	
	@Override
	public void draw(Graphics g, double x, double y) {
		if(image == null){
			g.drawRect((int) x, (int) y, (int) getPhysicalWidth(), (int) getPhysicalLength());
		} else {
			g.drawImage(image, (int) x, (int) y, (int) getPhysicalWidth(), (int) getPhysicalLength(), null);
		}
		
	}
	
	@Override
	public void toXML() {
		// TODO Auto-generated method stub
		
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageRef() {
		return imageRef;
	}

	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}
	
	public static SizeComparator getSizeComparator(){
		return new SizeComparator();
	}
	
	public static AlphabeticComparator getAlphabeticComparator(){
		return new AlphabeticComparator();
	}
	
	static class SizeComparator implements Comparator<StageObject> {
		public int compare(StageObject o1, StageObject o2) {
			return (int) ((o1.getPhysicalWidth() * o1.getPhysicalLength()) - (o2.getPhysicalWidth() * o2.getPhysicalLength()));
		}	
	}
	
	static class AlphabeticComparator implements Comparator<StageObject> {
		public int compare(StageObject o1, StageObject o2) {
			return o1.getName().compareTo(o2.getName());
		}	
	}

}