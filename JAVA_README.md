array 길이는 length, arraylist 길이는 size
arraylist 마지막 요소 삭제는 removeLast, 인덱싱은 getLast
string 동일 여부 판별은 eqauls, == 아님

숫자를 배열로 전환하는 방법

1.  숫자를 문자열로 변환하고, 문자열을 split("")으로 분리하기
    String[] stringArray = String.valueOf(number).split("");
2.  숫자를 문자 배열로 직접 변환하기
    char[] charArray = String.valueOf(number).toCharArray();

ArrayList에 값을 바로 넣어주려면, Arrays.asList(1, 2, 3, 4)

## 문제 풀이

배열 내용 출력

### String

1.  방법 1
    for (String s : string) {
    System.out.println(w);
    }
2.  방법 2
    System.out.print(Arrays.toArray(string))

### 문자로 타입 변경

toCharArray()
charAt()

String.valueof(num)
Arrays.asList(arr)

List<integer> num = new ArrayList<>();
int[] num = {}

num += n - '0'

## 입력

1. Scanner - 간단한 문제에 적합합

```
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine(); // 한 줄 전체 입력 받기

        System.out.println("안녕하세요, " + name + "님!");
    }
}
```

- 한 줄에 하나씩 입력
  int i = sc.nextInt()
  String s = sc.next()

- 한 줄 입력 받아서 쪼개기
  String line = sc.nextLine()
  String[] arr = line.split(" ")

2. BufferdReader + StringTokenizer - 입력이 많은 문제

```
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();                  // 한 줄 입력
        StringTokenizer st = new StringTokenizer(line); // 공백 기준으로 분리

        int a = Integer.parseInt(st.nextToken());     // 첫 번째 정수
        int b = Integer.parseInt(st.nextToken());     // 두 번째 정수

        System.out.println(a + b);                    // 출력
    }
}
```

## 배열

1. array - 동적으로 배열의 크기를 변경할 일이 없을 경우 사용
   int[] name = new int[n]
   String[] name = {...}
   array.length

2. ArrayList
   List<Integer> name = new ArrayList<>(n)

## 가변 배열

    List<Integer> list = new ArrayList<>()

    list.add(n) - 추가
    list.get(i) - 인덱싱
    list.size() - 배열 크기기

## Dict

    Map<String, Integer> map = new HashMap<>()

    map.put("k", 1) - 추가(key, value)
    map.get("k") - 인덱싱
    map.containsKey("key") - True/False

## Set

    Set<Integer> set = new HashSet<>()
    set.add(v)

## 문자열 처리

1. 문자열 길이
   s.length()

2. 문자 접근
   s.charAt(i)

3. 부분 문자열(s~e-1)
   s.subsstring(s, e)

4. 문자열 비교
   s.equals("abc")

5. 포함 여부
   s.contain("s")

6. 문자열 분리
   s.split("")

## 정렬

1. 오름차순
   Arrays.sort(arr)

2. 내림차순
   Arrays.sort(arr, Collections.reverseOrder())

## 함수

1. String
   startsWith(str) : 특정 문자로 시작되는지 판별
   endsWith(str) : 특정 문자로 끝나는지 판별
   equal(str) : 값 비교
   indexOf(str) : 특정 문자열이 몇 번재 인덱스에 위치하는지 반환, 없으면 -1
   substring
   substring(index) : index 포함하여 이후의 모든 문자열
   substring(s, e) : s~e-1까지
   replace(before, after) : 특정 문자열을 새로운 문자열로 치환
   charAt(n) : 특정 위치에 있는 문자 반환
   contains(str) : 특정 문자열 포함 확인
   split(regex) : 특정 문자열을 기준으로 분할 후 배열 반환

2. Arrays
   sort() : 오름차순 정렬
   Coleections.reverseOrder() : 내림차순 정렬
   asList(arr) : 배열을 ArrayList로 변환
   fill(arr, value) : 배열을 value 값으로 채움
   copyOf(arr, e) : 처음부터 e만큼 복사
   copyOfRange(arr, s, e) : start부터 e만큼 복사

3. 형 변환
   문자 -> 숫자
   Integer.valueOf(str) :
   Integer.parseInt(str)

   숫자 -> 문자
   String.valueOf(num)
   Integer.toString(num)

4. Collections
   sort
   max
   min
   reverse
   copy
   binarySearch
   disjoint(c1, c2) : 주어진 두 컬렉션에 일치하는 값이 하나도 없으면 true, 하나라도 있으면 false 반환

5. List
   add
   add(obj) : append
   add(index, obj) : insert
   remove
   remove(index) : pop(index)
   remove(obj) : remove(obj)
   contains(obj) : find(obj)
   get(c) : list[c]

6. Map
   put(key, value) : dict[key] = value
   get(key) : dict[key]
   remove(key) : key 삭제
   replace(key, value) : 특정 key에 해당하는 값을 value로 대체
   clear : 맵에 저장된 모든 객체 제거
   containsKey(key) : 특정 key가 있는지 판별
   keySet : 맵의 모든 key 반환
   entrySet : key, value Set 반환
   values : 맵의 모든 value 값 반환

7. Set

```

```
