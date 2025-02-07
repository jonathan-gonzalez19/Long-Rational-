public class LongRacional {
    private String whole;
    private String decimal;
    private boolean sign;
    
    
    public LongRacional(String w, String d, boolean s)
    {
        whole = w;
        decimal = d;
        sign = s;

    }
    public LongRacional(){
        whole = "0";
        decimal = "0";
        sign = true;
    }
    
    public LongRacional(String dec){
        int index = dec.indexOf(".");
        this.whole = dec.substring(0,index);
        this.decimal = dec.substring(index+1);
        
    }
    
    
    public String toString(){
        if(sign == false)
            return "-" + whole + "." + decimal;
        return  whole + "." + decimal;    
        
    }
    
    
    public LongRacional Negative()
    {
        
        return new LongRacional(whole,decimal,!sign);   
        
    }
    
    
    private int getNumericValue(String str){
         if (str.equals("0"))
            return 0;
        
         if (str.equals("1"))
            return 1;
         if (str.equals("2"))
            return 2;
         if (str.equals("3"))
            return 3;
         if (str.equals("4"))
            return 4;
         if (str.equals("5"))
            return 5;
         if (str.equals("6"))
            return 6;
         if (str.equals("7"))
            return 7;
         if (str.equals("8"))
            return 8;
        return 9;
    }
    private String integerToString(int num){
         if (num == 0)
            return "0";
        
         if (num == 1)
            return "1";
         if (num == 2)
            return "2";
         if (num == 3)
            return "3";
          if (num == 4)
            return "4";
          if (num == 5)
            return "5";
          if (num == 6)
            return "6";
          if (num == 7)
            return "7";
         if (num == 8)
            return "8";
        return "9";
    }
    
    
    public LongRacional Add(LongRacional c)
    {
        
        String dec1 = this.decimal;
        String dec2 = c.decimal;

        while(dec1.length() > dec2.length()){
            dec2=dec2+"0";
        }
        while(dec2.length() > dec1.length()){
            dec1=dec1+"0";
        }

        String sum = "";
        int carry = 0;
        for(int i = dec1.length()-1; i>=0; i-- ) {
            int current1 = getNumericValue(dec1.substring(i, i + 1));
            int current2 = getNumericValue(dec2.substring(i, i + 1));
            int currentSum = current1 + current2 + carry;
            if (currentSum >= 10) {
                carry = 1;
                currentSum -= 10;
            } 
            else
            {
                carry = 0;
            }

        sum = integerToString(Math.abs(currentSum)) + sum;
    }
       
       
       
       String whol = this.whole;
       String whol2 = c.whole;
       
       while(whol.length() > whol2.length()){
           whol2="0"+whol2;
       }
       while(whol2.length() > whol.length()){
           whol="0"+whol;
       }
       
       String sum_whole = "";
       
       for(int i = whol.length()-1; i>=0; i--)
       {
        int value1 = getNumericValue(whol.substring(i, i + 1));
        int value2 = getNumericValue(whol2.substring(i, i + 1));
        int currentSum = value1 + value2 + carry;
        
        if (currentSum >= 10) {
            carry = 1;
            currentSum -= 10;
        } 
        else 
        {
            carry = 0;
        }
        
        sum_whole = integerToString(currentSum) + sum_whole;
        
           
       }
       return new LongRacional(sum_whole,sum,sign);
       
       
        
    }
    
    public LongRacional Substract(LongRacional c)
    {
        
       String dec1 = this.decimal;
       String dec2 = c.decimal;
       
       while(dec1.length() > dec2.length()){
           dec2= "0" + dec2;
       }
       while(dec2.length() > dec1.length()){
           dec1= "0" + dec1;
       }
       
       String diff = "";
        int carry = 0;
        for (int i = dec1.length() - 1; i >= 0; i--) {
            int current1 = getNumericValue(dec1.substring(i, i + 1));
            int current2 = getNumericValue(dec2.substring(i, i + 1));
            int currentDiff = current1 - current2 - carry;
            if (currentDiff < 0) {
                carry = 1;
                currentDiff += 10;
            } else {
                carry = 0;
            }
            diff = String.valueOf(currentDiff) + diff;
        }
        
       
       
       
       String whol = this.whole;
       String whol2 = c.whole;
       carry = 0;
       
       while(whol.length() > whol2.length()){
           whol2="0"+whol2;
       }
       while(whol2.length() > whol.length()){
           whol="0"+whol;
       }
       
       String dif_whole = "";
       
       for(int i = whol.length()-1; i>=0; i--)
       {
        String current1 = whol.substring(i,i+1);
        String current2 = whol2.substring(i,i+1);
        int value1 = getNumericValue(current1);
        int value2 = getNumericValue(current2);
        int currentDiff = value1 - value2 - carry;
        if (currentDiff < 0) {
                carry = 1;
                currentDiff += 10;
            } else {
                carry = 0;
            }
        dif_whole = String.valueOf(currentDiff) + dif_whole;
       }
       return new LongRacional(dif_whole,diff,sign);
     
    }
    public LongRacional eliminateZeros()
    {
      String newWhol = "";
      String newDec = "";
      int index = 0;
      for(int i = 0; i<whole.length() ; i++ )
      {
        String current = whole.substring(i,i+1);
        
        if(!current.equals("0")){
            index = i;
            break;
        }
          
      }
      newWhol = whole.substring(index);
      
      index = 0;
      
      for(int i = decimal.length()-1;i>=0;i--)
      {
        String current = decimal.substring(i,i+1);
        
        if(!current.equals("0")){
            index = i;
            break;
        }
          
      }
      newDec = decimal.substring(0,index+1);
      
      return new LongRacional(newWhol,newDec,sign);
    }
    
    
    
    
}