function setBirthDatePicker() {
    $("#birthDate").datepicker({
        dateFormat: "yy-mm-dd", // 생년월일의 날짜 형식
        changeYear: true, // 연도 선택 가능 여부
        yearRange: "1900:2023" // 연도 범위 (1900년부터 2023년까지)
    });
};
$(document).ready(function() {
    setBirthDatePicker();
});