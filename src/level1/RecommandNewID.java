package level1;

/**
 * RecommandNewID
 */
public class RecommandNewID {

    /// Fields


    /// Constructor
    public RecommandNewID() {
        System.out.println( getClass().getName() + " Create Default Constuctor");
        problem();
    }

    /// Method
    public void problem() {
        
        /*
         * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
         * 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
         * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다. 
         */

        int key = 5;
        String new_id = "";
        switch (key) {
            case 1  :
                new_id = "...!@BaT#*..y.abcdefghijklm";
                break;
            case 2  :
                new_id = "z-+.^.";
                break;
            case 3  :
                new_id = "=.=";
                break;
            case 4  :
                new_id = "123_.def";
                break;
            case 5  :
                new_id = "abcdefghijklmn.p";
                break;
            default:
                break;
        }

        solution(new_id);
    }

    public void solution(String new_id) {

        String answer = "";

        System.out.println(" parameter new_id : " + new_id);

        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        answer =new_id.toLowerCase();
        System.out.println(" 1 단계 : " + answer );

        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        answer = answer.replaceAll("[^a-z0-9[-][_][.]]", "");
        System.out.println(" 2 단계 : " + answer );

        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        answer = answer.replaceAll("[.]{2,}", "\\.");
        System.out.println(" 3 단계 : " + answer );

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        answer = answer.replaceAll("^[.]|[.]$", "");
        System.out.println(" 4 단계 : " + answer );

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if("".equals(answer)) answer = "a";
        System.out.println(" 5 단계 : " + answer );

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //       만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(answer.length()>15) { 
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        // answer = answer.length()>=16?answer.substring(0, 15):answer;
        // answer = answer.replaceAll("[.]$", "");
        System.out.println(" 6 단계 : " + answer );
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(answer.length()<3)
            while(answer.length()<3)
                answer+=answer.charAt(answer.length()-1);
        System.out.println(" 7 단계 : " + answer);

    }
}