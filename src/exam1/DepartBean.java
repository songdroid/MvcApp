package exam1;

import java.util.ArrayList;

public class DepartBean {
	public ArrayList getAdvice(String choice){
		ArrayList list = new ArrayList();
		
		if(choice.equals("kor")){
			list.add("1. ��� ���ؾ� �Ѵ�");
			list.add("2. ��� ����ؾ� �Ѵ�.");
		}
		else if(choice.equals("eng")){
			list.add("1. ��� ���ؾ� �Ѵ�");
			list.add("2. ��� ����ؾ� �Ѵ�.");
		}
		else if(choice.equals("com")){
			list.add("1. ��ǻ�͸� ���ؾ� �Ѵ�");
			list.add("2. ��ǻ�͸� ����ؾ� �Ѵ�.");
		}
		
		return list;
	}
}
