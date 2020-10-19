# MeetingRooms

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
            return a.start - b.start; // return 값으로 오름차순 / 내림차순을 정할 수 있다.
        }
    };
```

# MoveZeros

## Problem

- 0이 아닌 요소의 상대적인 순서를 유지하면서 모든 0을 끝으로 이동시키는 함수를 작성하십시오

Input: [0,3,2,0,8,5]

Output: [3,2,8,5,0,0]

# TwoSum

## Problem

- 배열의 숫자들 중 두 숫자를 더해서 10이 되는 두 숫자의 위치를 반환하십시오

Input: int[] nums = [2,8,11,21];
        int target = 10;

Output: int[] = [1,2]

