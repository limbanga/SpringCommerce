package com.example.SpringCommerce.limbanga.helpers;

public class SlugHelper {
    public static String createSlug(String name) {
        // khai báo mảng chứa các ký tự tiếng việt có dấu
        String[] a = {"à", "á", "ạ", "ả", "ã", "â", "ầ", "ấ", "ậ", "ẩ", "ẫ", "ă", "ắ", "ằ", "ắ", "ặ", "ẳ", "ẵ", "a"};
        String[] d = {"đ", "d"};
        String[] e = {"è", "é", "ẹ", "ẻ", "ẽ", "ê", "ề", "ế", "ệ", "ể", "ễ", "e"};
        String[] i = {"ì", "í", "ị", "ỉ", "ĩ", "i"};
        String[] y = {"ỳ", "ý", "ỵ", "ỷ", "ỹ", "y"};
        String[] o = {"ò", "ó", "ọ", "ỏ", "õ", "ô", "ồ", "ố", "ộ", "ổ", "ỗ", "ơ", "ờ", "ớ", "ợ", "ở", "ỡ", "o"};
        String[] u = {"ù", "ú", "ụ", "ủ", "ũ", "ừ", "ứ", "ự", "ử", "ữ", "u", "ư"};
        // thay thế ký tự đặc biệt theo ý muốn
        name = name.replace(" ", "-");
        name = name.replace("#", "sharp");
        name = name.replace("$", "dola");
        // khai báo mảng ký tự đặt biệt
        String[] specialchars = {")", "(", "*", "[", "]", "}", "{", ">", "<", "=", ":", ",", "'", "\"", "/", "\\", "&",
                "?", ";", ".", "@", "^"};
        // chuyển qua chữ thường
        name = name.toLowerCase();
        // thay thế ký tự có dấu thành không dấu
        for (int k = 0; k < specialchars.length; k++)
            name = name.replace(specialchars[k], "");
        for (int k = 0; k < a.length; k++)
            name = name.replace(a[k], "a");
        for (int k = 0; k < d.length; k++)
            name = name.replace(d[k], "d");
        for (int k = 0; k < e.length; k++)
            name = name.replace(e[k], "e");
        for (int k = 0; k < i.length; k++)
            name = name.replace(i[k], "i");
        for (int k = 0; k < y.length; k++)
            name = name.replace(y[k], "y");
        for (int k = 0; k < o.length; k++)
            name = name.replace(o[k], "o");
        for (int k = 0; k < u.length; k++)
            name = name.replace(u[k], "u");
        return name;
    }
}
