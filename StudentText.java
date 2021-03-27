package referoffer;

/**
 * @author crazy邹
 * @create 2021/3/26 22:30
 */
class Student{
    int num;
    String name;
    int age;
    Student(int num,String name,int age){

        this.name = name;
        this.num = num;
        this.age = age;
    }
    Student(){
        super();
    }
    public void addAge(Student[] studentArray){
        for(int i = 0;i < studentArray.length;i++){
            studentArray[i].age += 1;
        }

    }
    public void sutPrint(Student[] studentArray){
        for (int i = 0;i <= studentArray.length - 1;i++){
            System.out.println("姓名：" + studentArray[i].name + "学号：" + studentArray[i].num + "年龄：" + studentArray[i].age);
        }
    }
    public void findStudent(Student[] studentArray){
        for (int i = 0;i <= studentArray.length - 1;i++){
            if (studentArray[i].age > 20){
                System.out.println("姓名：" + studentArray[i].name + "学号：" + studentArray[i].num + "年龄：" + studentArray[i].age);
            }
        }
    }
}
public class StudentText {
    public static void main(String[] args) {
        Student stu1 = new Student(15,"小明",19);
        Student stu2 = new Student(15,"小明",21);
        Student stu3 = new Student(15,"小明",22);
        Student[] studentArray = new Student[]{stu1,stu2,stu3};
        stu1.addAge(studentArray);
        System.out.println("学生信息如下：");
        stu1.sutPrint(studentArray);
        System.out.println();
        System.out.println("年龄超过20的名单：  ");
        stu1.findStudent(studentArray);

    }
}
