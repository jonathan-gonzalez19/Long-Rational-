public class MyProgram extends ConsoleProgram
{
    public void run()
    {
      LongRacional LR1 = new LongRacional("457","0",true);
      LongRacional LR2 = new LongRacional("123","0",true);
      LongRacional LR3 = new LongRacional("000005","4000000", true);
        
      System.out.println(LR1.Substract(LR2));    
      System.out.println(LR1.Add(LR2));   
      System.out.println(LR3.eliminateZeros());
        
    }
}