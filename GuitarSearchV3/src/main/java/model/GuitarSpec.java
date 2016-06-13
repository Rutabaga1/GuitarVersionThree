package main.java.model;
public class GuitarSpec {
 
  private Builder builder; 
  private String color;
  private Type type;
  private String numStrings;
  

  public GuitarSpec(Builder builder, String color, Type type,
		  String numStrings) {
    this.builder = builder;
    this.color = color;
    this.type = type;
    this.numStrings = numStrings;
    
  }

  public Builder getBuilder() {
    return builder;
  }

  public String getColor() {
    return color;
  }

  public Type getType() {
    return type;
  }

  public String getNumStrings() {
    return numStrings;
  }

  

  public boolean matches(GuitarSpec otherSpec) {
	 if(!otherSpec.type.toString().equals("allType")){ 
	   if (type != otherSpec.type)
		  return false;
	 }
    if(!otherSpec.builder.toString().equals("allBuilder")){  
		if (!builder.equals(otherSpec.builder))
			return false;
	}

	if(!otherSpec.numStrings.equals("")){
		if (!numStrings.equals(otherSpec.numStrings))
			return false;
	}
	
	if(!otherSpec.color.equals("")){
		int q=0;
		char gColor[]=color.toCharArray();
		char IColor[]=otherSpec.color.toCharArray();
		labe2:for (int j = 0; j < gColor.length; j++) {
			for (int k = 0; k < IColor.length; k++) {
				if(IColor[k]==gColor[j]){//针对汉字，考虑相似性
					q++;
					break labe2;
				}
			}}
    
		if (q==0)
			return false;
    }
    
    return true;
  }
}
