<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Employee Directory</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="../assets/css/styles.css" />
</head>
<body>
  <header>
    <h1>Employee Directory</h1>
    <div class="actions">
      <input type="text" id="searchInput" placeholder="Search by name or email..." />
      <button onclick="location.href='form.ftl'">Add Employee</button>
    </div>
  </header>

  <main id="employeeList">
    <!-- JavaScript will populate this -->
  </main>

  <script src="../assets/js/main.js"></script>
</body>
</html>