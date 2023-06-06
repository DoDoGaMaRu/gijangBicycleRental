let birthDate = new Date(birthDate_value);
let today = new Date();
let age = today.getFullYear() - birthDate.getFullYear();
let m = today.getMonth() - birthDate.getMonth();
if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
    age--;
}
let ageLimit = 19;
if (age < ageLimit) {
    let parentPhoneNumberRow = document.getElementById("parentPhoneNumberRow");
    let parentPhoneNumberCell = document.getElementById("parentPhoneNumberCell");
    parentPhoneNumberRow.style.display = "table-row";
    parentPhoneNumberCell.textContent = parentPhoneNumber_value;
}