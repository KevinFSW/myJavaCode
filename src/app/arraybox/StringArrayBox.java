/**
 * Edit and run with VSCode, default encoding: UTF-8
 */
package app.arraybox;

/**
 * 设计一个数组容器，能够不限定长度，能添加，删除，取出元素，能查询有效元素的个数
 * String类型的ArrayBox
 */
public class StringArrayBox extends ArrayBox<String>{
    
    public StringArrayBox(){
        super();
    }
	public StringArrayBox(int i) {
        super(i);
    }
    
}