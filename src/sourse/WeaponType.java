package sourse;

public enum WeaponType {
    AXE,
    PISTOL,
    SHOTGUN;
}

    /**
     * Генерирует список строковых значений enum'a.
     * @return Строка со всеми значениями перечисления, разделенными запятой.
     */

    public static String nameList() {
        String nameList = "";
        for (WeaponType weaponType : values()) {
            nameList += weaponType.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}