db.createUser({
    user: "user",
    pwd: "qwe123",
    roles: [
        { role: "readWrite", db: "pcc_docs" }
    ]
});