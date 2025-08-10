import  java.util.Scanner;
class Employee{
    private String employeeId;
    private String name;
    private int salary;
    private String department;
// 构造函数，用于创建Employee对象
    // 四个个参构造函数，用于创建Employee对象
    public Employee(String employeeId,String name, int salary, String department) {
        // 将传入的employeeId参数赋值给对象的employeeId属性
        this.employeeId = employeeId;
        // 将传入的name参数赋值给对象的name属性
        this.name = name;
        // 将传入的age参数赋值给对象的age属性
        this.salary = salary;
        // 将传入的address参数赋值给对象的address属性
        this.department = department;
    }
    // 无参构造函数，用于创建Employee对象
    public Employee(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入员工ID：");
        this.employeeId = sc.nextLine();
        System.out.print("请输入员工姓名：");
        this.name = sc.nextLine();
        System.out.print("请输入员工工资：");
        this.salary = sc.nextInt();
        System.out.print("请输入员工部门：");
        sc.nextLine();
        this.department = sc.nextLine();
    }
    // 有单个参构造函数，用于创建Employee对象
    public Employee(String employeeId){
        this.employeeId = employeeId;
        this.name = "无名氏";
        this.salary = 0;
        this.department = "待定";
    }
    // 有两个参构造函数，用于创建Employee对象
    public Employee(String employeeId,String name){
        this.employeeId = employeeId;
        this.name = name;
        this.salary = 0;
        this.department = "待定";
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    // 设置名字的方法
    public void setName(String name) {
        // 将传入的参数name赋值给成员变量name
        this.name = name;
    }
    // 设置年龄的方法
    public void setSalary(int salary) {
        this.salary = salary;
    }
    // 设置地址
    public void setDepartment(String department) {
        this.department= department;
    }

    // 获取员工ID
    public String getEmployeeId() {
        return employeeId;
        }
    // 获取name属性
    public String getName() {
        return name;
    }

    // 获取年龄
    public int getSalary() {
        return salary;
    }

    // 获取地址
    public String getDepartment() {
        return department;
    }
    public void printEmployee() {
        System.out.print("员工ID：" + this.employeeId);
        System.out.print(" ；员工姓名：" + this.name);
        System.out.print(" ；员工工资：" + this.salary);
        System.out.println(" ；员工部门：" + this.department);
    }

}
class employeeNode {
    private Employee employee;
    private employeeNode next;

    public employeeNode(Employee employee) {
        this.employee = employee;
        this.next = null;
    }

    public void addEmployee(employeeNode newEmployee) {
        if (this.next == null) {
            this.next = newEmployee;
        } else {
            this.next.addEmployee(newEmployee);
        }
        // 添加员工
    }

    /**
     * 打印员工节点信息的方法
     * 这是一个递归方法，用于遍历并打印链表中的所有员工信息
     */
    public void printEmployeeNode() {
        this.employee.printEmployee();
        // 打印当前节点的员工信息
        // 如果当前节点存在下一个节点，则继续执行打印操作
        if (this.next != null) {
            // 递归调用，打印下一个节点的员工信息
            this.next.printEmployeeNode();
        }

    }

    public void deleteEmployee(String employeeId) {
        if (this.next.employee.getEmployeeId().equals(employeeId)) {
            this.next = this.next.next;
        } else {
            this.next.deleteEmployee(employeeId);
        }
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public employeeNode getNext() {
        return this.next;
    }

    public boolean queryEmployee(String employeeId) {
        // 查询员工
        if (this.getEmployee() != null && this.getEmployee().getEmployeeId().equals(employeeId)) {
            // 如果节点的员工ID与输入的员工ID相同
            System.out.println("查询到该员工信息：");
            this.getEmployee().printEmployee();
            return true;
        } else if (this.next != null) {
            return this.next.queryEmployee(employeeId);
        }
        return false;
    }

/**
 * 根据员工ID搜索员工信息的方法
 * @param employeeId 要查询的员工ID
 */
    public employeeNode searchEmployee(String employeeId) {
        // 首先检查当前节点是否存在员工信息，并且员工ID是否匹配
        if (this.getEmployee() != null && this.getEmployee().getEmployeeId().equals(employeeId)) {
            // 如果节点的员工ID与输入的员工ID相同，则打印员工信息
            System.out.println("查询到该员工信息：");
            this.getEmployee().printEmployee();
            return this;
        } else if (this.next != null) {
            // 如果当前节点不匹配且存在下一个节点，则递归调用搜索方法
            return this.next.searchEmployee(employeeId);
        }
        return null;
    }
    public void modifyName() {
        System.out.print("请输入新的姓名：");
        Scanner sc = new Scanner(System.in);
        String newName = sc.nextLine();
        this.employee.setName(newName);
    }
    public void modifyId() {
        System.out.print("请输入新的员工ID：");
        Scanner sc = new Scanner(System.in);
        String newId = sc.nextLine();
        this.employee.setEmployeeId(newId);
    }
    public void modifySalary() {
        System.out.print("请输入新的工资：");
        Scanner sc = new Scanner(System.in);
        int newSalary = sc.nextInt();
        this.employee.setSalary(newSalary);
    }

    public void modifyDepartment() {
        System.out.print("请输入新的部门：");
        Scanner sc = new Scanner(System.in);
        String newDepartment = sc.nextLine();
        this.employee.setDepartment(newDepartment);
    }
}
class EmployeeLinkedList {
    private employeeNode head;
    public EmployeeLinkedList() {
        this.head = null;
    }
    public void printblank(int n) {
        for(int i=0;i<n;i++){
            System.out.print(" ");
        }
    }
    public void initChange() {//初始化修改界面
            printblank(20);
            System.out.print("-----员工数据系统-----\n\n");
            printblank(23);
            System.out.print("1.姓名\n");
            printblank(23);
            System.out.print("2.员工ID\n");
            printblank(23);
            System.out.print("3.薪资\n");
            printblank(23);
            System.out.print("4.部门\n");
            printblank(23);
            System.out.print("5.修改完成并退出\n");
            printblank(6);
            System.out.print("请选择你要修改的部分：");

    }
    public void addEmployee() {// 添加员工
        employeeNode newEmployee = new employeeNode(new Employee());
        if(this.head==null){
            this.head=newEmployee;
        }
        else {
            this.head.addEmployee(newEmployee);
        }
    }
    public void printEmployee() {
        if(this.head==null){
            System.out.println("没有员工信息！");
            return;// 打印员工
        }
        this.head.printEmployeeNode();
    }
    public void deleteEmployee() {
        String employeeId;
        System.out.print("请输入要删除的员工ID：");
        Scanner sc1 = new Scanner(System.in);
        employeeId = sc1.nextLine();
        if (this.head.getEmployee().getEmployeeId().equals(employeeId)) {
            this.head = this.head.getNext();
        }
        else {
            this.head.deleteEmployee(employeeId);
        }
        System.out.println("删除成功！");
    }
    public boolean queryEmployee() {
        // 查询员工
        String employeeId;
        System.out.print("请输入要查询的员工ID：");
        Scanner sc = new Scanner(System.in);
        employeeId = sc.nextLine();
        if(this.head.queryEmployee(employeeId)==false){
            System.out.println("没有找到该员工信息！");
            return false;
        }
        else {return true;}
    }
    public void modifyEmployee() {
        String employeeId;
        System.out.print("请输入要修改的员工ID：");
        Scanner sc = new Scanner(System.in);
        employeeId = sc.nextLine();
        employeeNode node = this.head.searchEmployee(employeeId);
        initChange();
        if(node==null){
            return;
        }
        int t = sc.nextInt();
        while (t != 5) {
            switch (t) {
                case 1:
                    node.modifyName();
                    break;
                case 2:
                    node.modifyId();
                    break;
                case 3:
                    node.modifySalary();
                    break;
                case 4:
                    node.modifyDepartment();
                    break;
                case 5:
                    System.out.println("修改成功！");
                    break;
                default:
                    System.out.println("输入错误！");
                    break;
            }
            initChange();
            t = sc.nextInt();
        }
    }
}

/**
 * Employee数据结构演示类
 * @AshSutimber
 * */
public class EmployeeDatStr {
    public static void printblank(int n) {
        for(int i=0;i<n;i++){
            System.out.print(" ");
        }
    }
    public static void init() {
        printblank(20);
        System.out.print("-----员工数据系统-----\n\n");
        printblank(23);
        System.out.print("1.添加员工\n");
        printblank(23);
        System.out.print("2.删除员工\n");
        printblank(23);
        System.out.print("3.查询员工\n");
        printblank(23);
        System.out.print("4.修改员工信息\n");
        printblank(23);
        System.out.print("5.打印员工信息\n");
        printblank(23);
        System.out.print("6.退出\n");
        printblank(12);
        System.out.print("请选择操作：");
    }
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        EmployeeLinkedList employeeLinkedList = new EmployeeLinkedList();
        while(true){
            init();
            t=sc.nextInt();
            switch (t) {
                case 1:
                    employeeLinkedList.addEmployee();
                    break;
                case 2:
                    employeeLinkedList.deleteEmployee();
                    break;
                case 3:
                    employeeLinkedList.queryEmployee();
                    break;
                case 4:
                    employeeLinkedList.modifyEmployee();
                    break;
                case 5:
                    employeeLinkedList.printEmployee();
                    break;
                case 6:
                    System.exit(0);

            }

        }
    }
}
