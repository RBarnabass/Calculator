package sample;

public class Deduction {
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";

    public String getResult(String str) {
        String[] list = str.split(" ");
        if (list[0].equals("")) {
            String[] newS = new String[list.length - 1];
            System.arraycopy(list, 1, newS, 0, list.length - 1);
            list = newS;
        }
        if (list[0].equals(MULTIPLICATION) || list[0].equals(DIVISION) || list[0].equals(ADDITION) || list[0].equals(SUBTRACTION)) {
            throw new ArithmeticException();
        }

        list = getSolution(list, MULTIPLICATION);
        list = getSolution(list, DIVISION);
        list = getSolution(list, ADDITION);
        list = getSolution(list, SUBTRACTION);
        return list[0] + "";
    }

    private String[] solution(String[] list, int i, String ch) {

        switch (ch) {
            case MULTIPLICATION: {
                if (list[i - 1].contains(".") || list[i + 1].contains(".")) {
                    list[i - 1] = (Double.parseDouble(list[i - 1]) * Double.parseDouble(list[i + 1])) + "";
                } else {
                    list[i - 1] = (Long.parseLong(list[i - 1]) * Long.parseLong(list[i + 1])) + "";
                }
                break;
            }
            case DIVISION: {
                if (list[i - 1].contains("Infinity") || list[i + 1].contains("Infinity") || list[i - 1].contains("NaN") || list[i + 1].contains("NaN")) {
                    throw new ArithmeticException();
                }
                list[i - 1] = (Double.parseDouble(list[i - 1]) / Double.parseDouble(list[i + 1])) + "";
                if (list[i - 1].contains("Infinity") || list[i + 1].contains("Infinity")) {
                    throw new ArithmeticException();
                }
                break;
            }
            case ADDITION: {
                if (list[i - 1].contains(".") || list[i + 1].contains(".")) {
                    list[i - 1] = (Double.parseDouble(list[i - 1]) + Double.parseDouble(list[i + 1])) + "";
                } else {
                    list[i - 1] = (Long.parseLong(list[i - 1]) + Long.parseLong(list[i + 1])) + "";
                }
                break;
            }
            case SUBTRACTION: {
                if (list[i - 1].contains(".") || list[i + 1].contains(".")) {
                    list[i - 1] = (Double.parseDouble(list[i - 1]) - Double.parseDouble(list[i + 1])) + "";
                } else {
                    list[i - 1] = (Long.parseLong(list[i - 1]) - Long.parseLong(list[i + 1])) + "";
                }
                break;
            }
        }
        String[] newS = new String[list.length - 2];
        if (i - 1 >= 0) {
            System.arraycopy(list, 0, newS, 0, newS.length);
            System.arraycopy(list, i + 2, newS, i, list.length - i - 2);
            list = newS;
        }
        return list;
    }

    private String[] getSolution(String[] list, String ch) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(ch)) {
                list = solution(list, i, ch);
                list = getSolution(list, ch);
            }
        }
        return list;
    }
}