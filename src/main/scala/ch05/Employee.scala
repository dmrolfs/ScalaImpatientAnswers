package ch05


/*
 * 10. Consider the class
 * class Employee(val name: String, var salary: Double) {
 *   def this() { this("John Q. Public", 0.0) }
 * }
 *
 * Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?
 */
class Employee( val name: String = "John Q. Public", var salary: Double = 0.0 )

object Exercise10 extends App {
  val employee = new Employee
  println( s"""Ex10: employee.name = ${employee.name}""")
  println( s"""Ex10: starting employee.salary = ${employee.salary}""")
  employee.salary = 9823.09
  println( s"""Ex10: updated employee.salary = ${employee.salary}""")
}