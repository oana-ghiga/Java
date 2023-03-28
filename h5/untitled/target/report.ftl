<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document Catalog Report</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        h1, h2 {
            margin-top: 40px;
        }
    </style>
</head>
<body>
<h1>Document Catalog Report</h1>

<h2>Document List</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Type</th>
        <th>Path</th>
        <th>Tags</th>
    </tr>
    </thead>
    <tbody>
    <#list documents as doc>
        <tr>
            <td>${doc.id}</td>
            <td>${doc.name}</td>
            <td>${doc.type}</td>
            <td><#if doc.path??>${doc.path}<#else>-</#if></td>
            <td>
                <#list doc.tags?keys as key>
                    ${key}: ${doc.tags[key]}<#sep>, </#sep>
                </#list>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>
