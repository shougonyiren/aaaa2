package activitytest.example.com.aaaa;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button kong, deng, jia, jian, cheng, chu,del,dian,bai, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    private TextView textView,textView1;

    List<Button> list = new ArrayList<Button>();//按钮
    List<Integer> thisnum= new ArrayList<Integer>();//临时数字
    List<Character> stack = new ArrayList<Character>();//表达式
    Stack<Character> SOP = new Stack<Character>();//临时存储运算符和分界符(
    List<String> L = new ArrayList<String>();//后缀表达式
    Stack<BigDecimal> scalc = new Stack<BigDecimal>();//后缀表达式运算栈
    boolean ClearA = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView1= (TextView) findViewById(R.id.textView1);
        Intio();
    }

    private void Intio() {
        bai= (Button) findViewById(R.id.buttonbai);
        dian= (Button) findViewById(R.id.buttondian);
        del = (Button) findViewById(R.id.buttondel);
        deng = (Button) findViewById(R.id.buttonA);
        kong = (Button) findViewById(R.id.buttonB);
        jia = (Button) findViewById(R.id.buttona);
        jian = (Button) findViewById(R.id.buttonb);
        cheng = (Button) findViewById(R.id.buttonc);
        chu = (Button) findViewById(R.id.buttond);
        b0 = (Button) findViewById(R.id.button0);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);
        list.add(b7);
        list.add(b8);
        list.add(b9);
        list.add(b0);
        list.add(jia);
        list.add(jian);
        list.add(cheng);
        list.add(chu);
        list.add(deng);
        list.add(kong);
        list.add(del);
        list.add(dian);
        list.add(bai);
        for (int i = 0; i < 19; i++) {
            list.get(i).setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonbai:
                ClearA=false;
                stack.add('%');
                break;
            case R.id.buttondian:
                ClearA=false;
                stack.add('.');

                break;
            case R.id.button0:
                if(ClearA){
                   stack.clear();
                    ClearA=false;
                }
                stack.add('0');
                break;
            case R.id.button1:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('1');
                textView.setText(stack.toString());
                break;
            case R.id.button2:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('2');
                break;
            case R.id.button3:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('3');
                break;
            case R.id.button4:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('4');
                break;
            case R.id.button5:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('5');
                break;
            case R.id.button6:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('6');
                break;
            case R.id.button7:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('7');
                break;
            case R.id.button8:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('8');
                break;
            case R.id.button9:
                if(ClearA){
                    stack.clear();
                    ClearA=false;
                }
                stack.add('9');

                break;
            case R.id.buttonA://等于号
                BigDecimal re;
                ClearA=true;
                //STACKcompress() 变为后缀表示式
                if(STACKcompress()) {//是否正确运行
                    re = suffixToResult();//运算
                    if (!textView1.getText().equals("错误")) {
                        textView.setText(re.toString());
                        stack.clear();
                        String sss = re.toPlainString();
                        for (int i = 0; i < sss.length(); i++) {
                            char ss = sss.charAt(i);
                            stack.add(ss);
                        }
                    }
                }else if(stack.size()==1){  //只有一个元素
                    Character character = stack.get(0);
                    if(character!='-'){
                        textView1.setText("错误");
                        stack.clear();
                    }else{
                        textView.setText('-');
                    }
                }
                return;
            case R.id.buttonB:
                ///////C
                stack.clear();
                break;
            case R.id.buttona:
                ClearA=false;
                if(stack.isEmpty()) break;
                stack.add('+');
                break;
            case R.id.buttonb:
                ClearA=false;
                stack.add('-');
                break;
            case R.id.buttondel:
                ClearA=false;
           if(stack.isEmpty()) break;
                stack.remove(stack.size()-1);
                TextView();
                break;
            case R.id.buttonc:
                ClearA=false;
                if(stack.isEmpty()) break;
                stack.add('*');
                break;
            case R.id.buttond:
                ClearA=false;
                if(stack.isEmpty()) break;
                stack.add('/');
                break;
        }
        TextView();
    }
    private void TextView(){
        String thestack = "";
        for (int i = 0; i < stack.size(); i++) {

            thestack = thestack + stack.get(i);
        }
        textView.setText(thestack);
    }
    private void TextView1(String a){
        textView1.setText(a);
    }
    private boolean SopTureOrFlase(char a) {
        if (!SOP.empty()&&SwitchOperator(a)) {
            boolean[][] OP = new boolean[10][10];//OperationalPriority 运算优先级
            int x = 10, y = 10;
            OP[0][0] = true;
            OP[0][1] = true;
            OP[0][2] = true;
            OP[0][3] = true;
            OP[1][0] = true;
            OP[1][1] = true;
            OP[1][2] = true;
            OP[1][3] = true;

            OP[2][0] = false;
            OP[2][1] = false;
            OP[2][2] = true;
            OP[2][3] = true;
            OP[3][0] = false;
            OP[3][1] = false;
            OP[3][2] = true;
            OP[3][3] = true;
            y = SwitchXYInOperator(SOP.peek());
            x = SwitchXYInOperator(a);
            Log.d("SopTureOrFlase",String.valueOf(OP[x][y]));
            return OP[x][y];
  /*       {
            if (SOP.peek() == '*' || SOP.peek() == '/') {
                return true;
            } else if ((SOP.peek() == '-' || SOP.peek() == '+') && (a == '-' || a == '+')) {
                return true;
            }
        }
        return false;*/

        }else return false;
    }
    @SuppressLint("LongLogTag")
    private BigDecimal suffixToResult() { //运算后缀表达式
        BigDecimal temp_value ;

        for (int i = 0; i < L.size(); i++) {
           String element1 = L.get(i);
           Log.d("L",L.toString());
            char element = element1.charAt(0);//获取字符串的第一个字符
            Log.d("String.valueOf(BigDecimal.valueOf(element))", String.valueOf(BigDecimal.valueOf(element)));
           if (SwitchOperator(element)) {
               Log.d("是操作符", String.valueOf(element));
                //从栈中弹出2个操作数 num1 和 num2 。注意：后弹出的num2是第一操作数，num1是第二操作数 。
                //因为这里考虑的都是二元运算符，因此需要弹2个元素出来进行运算。
               try{
                   BigDecimal num1 = scalc.pop();
                   BigDecimal num2 = scalc.pop();

                   switch (element) {
                       case '+':
                           temp_value = num2.add(num1) ;
                           break;
                       case '-':
                           temp_value = num2.subtract(num1) ;
                           break;
                       case '*':
                           temp_value = num2.multiply(num1);
                           break;
                       case '/':
                               temp_value = num2.divide(num1) ;
                           break;
                       default:
                           temp_value = BigDecimal .valueOf(999);
                           break;
                   }
                   //将temp_value压栈
                   TextView1("");
                   scalc.push(temp_value);
               }catch (EmptyStackException e) {
                  TextView1("错误");
                  return BigDecimal .valueOf(-1);
               }
                //使用element代表的运算符完成 num2 和 num1 的计算，产生临时结果 temp_value
            }  else {
               BigDecimal bd = new BigDecimal(element1);
              Log.d("bd", bd.toString()) ;
           scalc.push(bd);
         }
        }Log.d("scalc",scalc.toString());
         BigDecimal x=scalc.pop();
        Log.d("x",x.toString());
        return x;
    }
    private boolean STACKcompress() {
//将参数中缀表达式expression转为后缀表达式存放在L中，返回L
          L.clear();
          SOP.clear();
          Log.d("stack",stack.toString());
          int dian =0;  //
          boolean  dia=false;    //
        for (int i = 0; i < stack.size(); i++)        //对表达式中的每一个元素
        {
            char element = stack.get(i);
            if ('0' <= element && element <= '9') {
                if(dia){
                    dian++;
                }
                thisnum.add(element-'0');

                Log.d("(int) element", String.valueOf(element-'0'));
                if(i +1==stack.size()){
                    BigDecimal ten=BigDecimal.valueOf(10);
                    BigDecimal zxc= BigDecimal.valueOf(0);
                    for(int a=0;a<thisnum.size();a++){
                        zxc=zxc.multiply(ten);
                        zxc=zxc.add(BigDecimal.valueOf(thisnum.get(a)));
                    }
                    if(dia){
                        for(int a=0;a<dian;a++){
                            zxc=zxc.divide(ten);
                        }
                        dia=false;
                        dian=0;
                    }
                    L.add(""+zxc);
                    thisnum.clear();
                    Log.d("String(zxc) i+1 ", ""+zxc);
                }
            } else if (SwitchOperator(element)) {
                if(stack.size()==1&&element!='-'){
                    Log.d("element in if",""+element);
                    return false;
                }
                if(!thisnum.isEmpty()){
                    BigDecimal ten=BigDecimal.valueOf(10);
                    BigDecimal zxc= BigDecimal.valueOf(0);
                    for(int a=0;a<thisnum.size();a++){
                        zxc=zxc.multiply(ten);
                        zxc=zxc.add(BigDecimal.valueOf(thisnum.get(a)));
                    }
                    if(dia){
                        for(int a=0;a<dian;a++){
                            zxc=zxc.divide(ten);
                        }
                        dia=false;
                        dian=0;
                    }
                    L.add(""+zxc);
                    thisnum.clear();
                    Log.d("String(zxc) i+1 ", ""+zxc);
                }
                while(SopTureOrFlase(element)) {
                    L.add(""+SOP.pop());
                }
                if(i +1!=stack.size()) {
                    SOP.push(element);
                }else if(stack.size()!=1){
                    return  false;
                }

            }else if(element=='.'){
                dia=true;
            }else  if(element=='%'){
                if(!thisnum.isEmpty()) {
                    BigDecimal ten=BigDecimal.valueOf(10);
                    BigDecimal zxc = BigDecimal.valueOf(0);
                    for (int a = 0; a < thisnum.size(); a++) {
                        zxc=zxc.multiply(ten);
                        zxc=zxc.add(BigDecimal.valueOf(thisnum.get(a)));
                    }
                    Log.d("thisnum", thisnum.toString());
                    thisnum.clear();
                    zxc=zxc.divide(BigDecimal.valueOf(100));
                    Log.d("zxc", "" + zxc);
                    L.add("" + zxc);
                }
            } else{
                textView.setText("警告 :不在按键中的字符出现");
                Log.e("警告","不在按键中的字符出现");
                this.onStop();
            }
        }
            while (!SOP.isEmpty())      //将sop栈中剩余的所有元素弹出，追加到L后
            {
                L.add(""+SOP.pop());

            }
      return true;
    }
            /*        else if(element 是 一个分界符)
                {
                    if (element is  '('  )
                    {
                        sop.push(element)
                    }
            else if( element is  ')'  )
                    {
                        While (sop栈不为空 &&   sop栈顶元素 不是 '('  )    #将匹配的2个括号之间的栈元素弹出，追加到L
                        {
                            L.append( sop.pop() );
                        }
                        if(sop栈不为空 )
                        {
                            sop.pop()           #将匹配到的 '(' 弹出丢弃
                        }
                    }
                }*/


    private boolean SwitchOperator(Character q) {
        switch (q) {
            case '+':
                Log.d("加",q.toString());
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            default:
                return false;
        }
    }
    private int SwitchXYInOperator(Character q) {
        int x = 9;
        switch (q) {
            case '+':
                x = 0;
                break;
            case '-':
                x = 1;
                break;
            case '*':
                x = 2;
                break;
            case '/':
                x = 3;
                break;
            default:
                x = 9;
                break;
        }
        return x;
    }

}


