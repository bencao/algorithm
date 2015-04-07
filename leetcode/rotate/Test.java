class Test {
  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    change(a);    
    System.out.println(a[1]);
  }

  public static void change(int[] arr) {
    arr[1] = 4;
  }
}
