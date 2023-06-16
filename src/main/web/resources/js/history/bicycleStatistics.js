function validateForm() {
    const idInput = document.querySelector('.input_bicycleId');
    const stateSelect = document.querySelector('.select_bicycleState');

    // 입력 필드가 빈 값인 경우
    if (idInput.value.trim() === "") {
        idInput.name = ""; // name 속성 제거
    }

    // 상태 선택 필드에서 '전체'를 선택한 경우
    if (stateSelect.value === "전체") {
        stateSelect.name = ""; // name 속성 제거
    }

    return true; // 폼 전송
}