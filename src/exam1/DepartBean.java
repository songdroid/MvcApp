package exam1;

import java.util.ArrayList;

public class DepartBean {
	public ArrayList getAdvice(String choice){
		ArrayList list = new ArrayList();
		
		if(choice.equals("kor")){
			list.add("1. 국어를 잘해야 한다");
			list.add("2. 국어를 사랑해야 한다.");
		}
		else if(choice.equals("eng")){
			list.add("1. 영어를 잘해야 한다");
			list.add("2. 영어를 사랑해야 한다.");
		}
		else if(choice.equals("com")){
			list.add("1. 컴퓨터를 잘해야 한다");
			list.add("2. 컴퓨터를 사랑해야 한다.");
		}
		
		return list;
	}
}
