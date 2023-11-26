function changeSortBy() {
    let sortBy = document.getElementById("sortBy").value;
    window.location = "getAll?sortBy=" + sortBy;
}

function changeDirection() {
    let direction = document.getElementById("direction").value;
    window.location = "getAll?direction=" + direction;
}
