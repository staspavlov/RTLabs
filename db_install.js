// Создаем БД
use statistics;

// Создаем пользователя
db.createUser({
    user: 'test',
    pwd: 'test',
    roles: [{ role: 'readWrite', db:'statistics'}]
});

// Авторизуемся под пользователем
db.auth('test', 'test');
