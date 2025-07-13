<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Add/Edit Employee</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="../assets/css/styles.css" />
</head>
<body>
  <h2 id="formTitle">Add Employee</h2>
  <form id="employeeForm">
    <input type="hidden" id="employeeId" />

    <label>First Name</label>
    <input type="text" id="firstName" required />

    <label>Last Name</label>
    <input type="text" id="lastName" required />

    <label>Email</label>
    <input type="email" id="email" required />

    <label>Department</label>
    <input type="text" id="department" required />

    <label>Role</label>
    <input type="text" id="role" required />

    <div class="form-actions">
      <button type="submit">Save</button>
      <button type="button" onclick="location.href='index.ftl'">Cancel</button>
    </div>
  </form>

  <script src="../assets/js/form.js"></script>
</body>
</html>