class Main
{

  public static void main(String[] args) {
  int[] gd1 = {95,97,100};
  int[] gd2 = {92,93,94};
  int[] gd3 = {87,86,90};
  System.out.println("Code by KEYUR MARU");
  Student[] students = new Student[3];
  students[0] = new Student("John Doe", 3);
  students[0].setGrade(gd1);

  students[1] = new Student("Jane Smith", 3);
  students[1].setGrade(gd2);

  students[2] = new Student("Billy Bob", 3);
  students[2].setGrade(gd3);

  int[] cpy1 = students[0].getGrades();
  int[] cpy2 = students[1].getGrades();
  int[] cpy3 = students[2].getGrades();

System.out.printf("%s %d %d %d\n", students[0].getName() ,
cpy1[0], cpy1[1], cpy1[2]);

System.out.printf("%s %d %d %d\n", students[1].getName() ,
cpy2[0], cpy2[1], cpy2[2]);

System.out.printf("%s %d %d %d\n", students[2].getName() ,
cpy3[0], cpy3[1], cpy3[2]);
  }

}