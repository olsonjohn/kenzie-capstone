import createPage from "../components/createPage";
import { DateTime } from "luxon";
import ApiClient from "../api/apiClient";

function registerPage() {
  const client = new ApiClient();

  createPage("Register");

  const createUserForm = document.createElement("form");
  createUserForm.id = "createUserForm";

  const fields = document.createElement("div");
  fields.classList.add("formArea");

  function createInputField(id, label, type, placeholder, isRequired) {
    const field = document.createElement("div");
    const labelElement = document.createElement("label");
    labelElement.htmlFor = id;
    labelElement.textContent = label + ":";

    const inputElement = document.createElement("input");
    inputElement.type = type;
    inputElement.id = id;
    inputElement.name = id;
    inputElement.placeholder = placeholder;
    if (isRequired) inputElement.required = true;

    if (id === "email") {
      field.classList.add("emailAddressInput");
    } else {
      field.classList.add("formInput");
    }
    field.append(labelElement, inputElement);
    fields.append(field);
  }

  createInputField("username", "Username", "text", "UserName", true);
  createInputField("password", "Password", "password", "Password", true);
  createInputField("firstname", "First Name", "text", "First Name", false);
  createInputField("lastname", "Last Name", "text", "Last Name", false);
  createInputField("email", "Email", "email", "Email Addres", false);

  const buttonGroup = document.createElement("div");
  buttonGroup.classList.add("btnGroup");

  const canceltBtn = document.createElement("button");
  canceltBtn.innerText = `Cancel`;
  canceltBtn.classList.add("outline", "secondary");
  canceltBtn.addEventListener("click", () => {
    window.location.href = "/";
  });
  const submitBtn = document.createElement("input");
  submitBtn.setAttribute("type", "submit");

  buttonGroup.append(canceltBtn, submitBtn);

  createUserForm.append(fields, buttonGroup);

  createUserForm.addEventListener("submit", submitForm);

  async function submitForm(event) {
    event.preventDefault();
    const now = DateTime.now()
      .setZone("America/Chicago")
      .toLocaleString(DateTime.DATE_SHORT);

    let formData = new FormData(event.target);
    formData.append("date_joined", now);
    formData.append("address", "");
    formData.append("phoneNum", "");

    try {

      const response = await client.createUser(client.createPayload(formData));
      if (response) {
        window.sessionStorage.setItem("userInfo", JSON.stringify(response));
        window.location.href = "/";
      }
    } catch (error) {
      console.error(error);
      const form = document.querySelector("#createUserForm");
      const div = document.createElement("section");
      div.classList.add("warningBox");
      div.innerHTML = `<strong>Error:</strong> ${error.message}`;
      form.after(div);
    }
  }

  const pageContent = document.querySelector("#pageContent");
  pageContent.append(createUserForm);
}

export default registerPage;
