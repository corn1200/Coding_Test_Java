# [String & Array]

# MeetingRoom

## Problem

input: [[0,30],[5,10],[15,20]]

Output: false
* * *
input: [[7,10],[2,4]]

Output: true

## 해설

미팅룸 한 곳에서 회의를 하는데 회의 시간이 겹치지 않아야합니다.

회의에 대한 정보로 시작 시간(start)과 종료 시간(end)을 받습니다.

```
class Interval { // Interval(간격) 클래스 생성
    int start; // 회의의 시작 시간
    int end; // 회의의 종료 시간

    Interval() {
        this.start = 0;
        this.end = 0;
    }

    Interval(int s, int e) { // 회의 객체를 만들 때 시작 시간과 종료 시간을 입력 받는다.
        this.start = s;
        this.end = e;
    }
}
```

최적의 계산으로 모든 회의가 한 미팅룸에서 해결할 수 있는지(true or false)
알기 위해서 우선 회의 시작 시간(start)을 기준으로 정렬을 해야합니다.

객체를 정렬하는 방법 중에 Array.sort 메소드를 사용해 정렬하고자 한다면 객체의 클래스에 Comparable 인터페이스를 implements 하고 내부에 compareTo 메소드를 재정의하여 객체 정렬 규칙을 정하는 방법과
compare 메소드를 재정의하여 객체 정렬 규칙을 정한 Comparator 객체를 Array.sort 에 인자로 추가하는 방법이 있습니다.

아래는 후자의 방법을 채용한 것입니다.

```
Comparator<Interval> Comp = new Comparator<Interval>() { // Comp 변수에 Comparator 객체를 생성해준다.

        @Override
        public int compare(Interval a, Interval b) { // compare 메소드를 재정의 해서 객체 정렬 규칙을 정한다.
            // return b.start - a.start;
            return a.start - b.start; // return 값으로 오름차순 / 내림차순을 정할 수 있습니다.
        }
    };
```

# MoveZero

## Problem

- 0이 아닌 요소의 상대적인 순서를 유지하면서 모든 0을 끝으로 이동시키는 함수를 작성하십시오

Input: [0,3,2,0,8,5]

Output: [3,2,8,5,0,0]

## 해설

0을 제외한 모든 숫자를 왼쪽으로 밀면서 0을 제외한 숫자들의 순서는 유지하는게 조건입니다.
배열을 한개씩 확인하면서 0이 아닌 경우일 때 마다 0부터 시작하는 인덱스에 저장할것이고, 인덱스를 증가시킬것입니다.

```
int[] nums = {0, 3, 2, 0, 8, 5};
        int index = 0;
```

우선 배열 안에 값을 입력합니다.
인덱스의 시작은 0 입니다.
index 변수를 기준으로 0이 아닌 숫자와 조우할 때 마다 index 번 째 배열에 값을 저장하고, index 의 값은 증가합니다.

```
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
```

0이 아닌 숫자를 발견하면 index 번 째 배열에 해당 값을 저장합니다.
index 의 값을 증가시켜 다음 0이 아닌 숫자가 다음 배열에 순서대로 저장되도록 합니다.

```
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
```

배열의 값을 전부 확인하고 0이 아닌 숫자를 왼쪽으로 밀고 나면 index 의 값은 배열 속 0이 아닌 숫자만큼 증가되었을것입니다.
때문에 나머지 0이었던 숫자들은 현재 index 를 기준으로 배열의 크기만큼 반복해서 남은 배열에 0을 입력하면 바라는 동작이 완성됩니다.

# TwoSum

## Problem

- 배열의 숫자들 중 두 숫자를 더해서 10이 되는 두 숫자의 인덱스를 반환하십시오

Input: int[] nums = [2,8,11,21] / int target = 10

Output: int[] = [1,2]

## 해설

보통 배열의 숫자를 조합해서 특정 숫자를 만드는 작업은 경우에 따라 굉장히 많은 작업이 요구됩니다. 
그래서 이 문제는 HashMap 의 특징을 살려 풉니다.

```
int[] nums = {2, 8, 11, 21};
        int target = 10;
        TwoSum a = new TwoSum();
        int[] result = a.solve(nums, target);
```

우선 배열에 숫자를 입력합니다. 그리고 배열의 숫자를 조합해 만들 숫자를 target 변수에 저장합니다.
solve 메소드에 배열과 target 을 넘깁니다. 그럼 solve 메소드 안에선 넘겨 받은 파라미터로 아래와 같은 동작을 합니다.

```
public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
```

우선 Integer 값을 저장하는 HashMap 변수를 생성하고, 조합해서 target 의 숫자가 되는 두 숫자의 위치를 저장할 배열도 생성합니다.

```
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int mapValue = map.get(nums[i]);
                result[0] = mapValue + 1;
                result[1] = i + 1;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }
```

현재 map 변수에는 아무 값도 존재하지 않습니다. 때문에 첫번째 for 동작에서 if 의 조건은 충족되지 않고 else 로 넘어갑니다. 
map 에 각각 target 에서 현재 배열 값에서 뺀 값(현재 배열 값이 어떤 숫자와 조합해야 목표값이 나오는지 판별)과 현재 배열의 위치가 저장됩니다. 
계속 반복하며 현재 배열 값과 조합하여 목표에 도달 값이 map 에 있는지 찾습니다(containsKey). 만약 있다면 map 에서 해당 값의 위치를 불러오고 현재 배열의 위치와 함께 result 배열에 저장합니다.
이는 각각 몇번째 배열에 target 을 만족하는 값이 있는지를 나타냅니다.

```
        for (int i : result) {
            System.out.println(i);
        }
```

찾아낸 조합이 몇번째인지는 배열에 담겨있고 그 배열을 출력합니다.

# DailyTemperature

## Problem

- 각 날짜를 기준으로 며칠 뒤에 더워지나 출력하십시오

int[] nums = [73,74,75,71,69,72,76,73]

Output: 1 1 4 2 1 1 0 0

# MergeInterval

## Problem

- 겹치는 구간은 맨 앞과 맨 뒤로 병합하여 출력하십시오

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]

# MeetingRoom2

## Problem

- 회의 시간표를 보고 몇개의 회의실이 필요한지 출력하십시오

Input: [[0,30],[5,10],[15,20]]

Output: 2
* * *
Input: [[7,10],[2,4]]

Output: 1

# JewelsAndStones

## Problem

- Stone 속에 Jewel 에 해당하는 값(char)이 얼마나 있는지 출력하십시오

Input: J = "aA", S = "aAAbbbb"

Output: 3

# LicenseKeyFormatting

## Problem

- 뒤에서 k의 값만큼의 간격에 "-" 삽입 & 대문자로 출력하십시오

Input: String str = "8F3Z-2e-9-w"

String str = "8-5g-3-J"

int k = 4

Output: 8F3Z-2E9W, 8-5G3J