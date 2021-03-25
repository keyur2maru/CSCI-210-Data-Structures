class Student
{
  private String name;
  private int numofGrades;
  private int[] grades;

  public Student(String name, int numofGrades)
  {
    this.name = name;
    this.numofGrades = numofGrades;
  }
public String getName()
{
  return name;
}
  public int getnumofGrades()
  {
    return numofGrades;
  }
  public void setGrade(int[] gr)
  {
    this.grades = gr;
  }
  public int[] getGrades()
  {
    return this.grades;
  }
}