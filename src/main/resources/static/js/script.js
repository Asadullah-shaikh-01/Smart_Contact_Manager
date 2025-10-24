console.log("Home page");

let currentTheme = getTheme();
// changeTheme(currentTheme);

//initial
document.addEventListener("DOMContentLoaded", () => {
    changeTheme();
})


//ToDO
function changeTheme(currentTheme) {
  //set web theme
  changePageTheme(currentTheme, currentTheme);

  //set listner to change theme
  const changeThemeButton = document.getElementById("#theme_change_button");
  changeThemeButton.addEventListener("click", (event) => {
    if (currentTheme == "dark") {
      // setTheme("light");
      currentTheme = "light";
    } else {
      currentTheme = "dark";
    }
    changePageTheme(currentTheme, oldTheme);
  });
}

// set local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from local storage
function getTheme() {
  let theme = localStorage.getItem("theme");
  if (theme) {
    return theme;
  } else return "light";
}

function changePageTheme(theme, oldTheme) {
  //locaal storage
  setTheme(currentTheme);
  //remove current theme
  document.querySelector("html").classList.remove(oldTheme);
  //set web theme
  document.querySelector("html").classList.add(theme);

  //change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "Light" ? "Dark" : "Light";
}
