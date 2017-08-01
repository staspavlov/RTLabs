// Создаем заявителей
db.createCollection('persons');

var persons = [
    {type: 'IP', name: 'Александров А.А.'},
    {type: 'IP', name: 'Иванов И.И.'},
    {type: 'IP', name: 'Петров П.П.'},
    {type: 'UL', name: 'Сидоров С.С.'},
    {type: 'UL', name: 'Андреев А.А.'},
    {type: 'UL', name: 'Богданов Б.Б.'},
    {type: 'FL', name: 'Алексеев А.А.'},
    {type: 'FL', name: 'Борисов Б.Б.'},
    {type: 'FL', name: 'Антонов А.А.'}
];

for (var i = 0; i < persons.length; i++) {
    persons[i]['_id'] = new ObjectId();
    db.persons.insert(persons[i]);
}

// Создаем ведомства
db.createCollection('departments');

var departments = [
    {code: 'ms', title: 'Министерство связи'},
    {code: 'mk', title: 'Министерство культуры'},
    {code: 'kn', title: 'Комитет по делам науки'},
    {code: 'sm', title: 'Совет Министров'}
];

for (var i = 0; i < departments.length; i++) {
    departments[i]['_id'] = new ObjectId();
    db.departments.insert(departments[i]);
}

// Создаем услуги и подуслуги
db.createCollection('services');

var services = [
    {
        title: 'Услуги почтовой связи', recipientType: 'IP', subservices: [
            {title: 'Пересылка посылок'}, {title: 'Пересылка денежных переводов'}
        ]
    },
    {
        title: 'Услуги банков', recipientType: 'IP', subservices: [
            {title: 'Прием налогов'}, {title: 'Выдача долгосрочных ссуд'}
        ]
    },
    {
        title: 'Услуги питания', recipientType: 'IP', subservices: [
            {title: 'Услуги питания кафе'}
        ]
    },
];

for (var i = 0; i < services.length; i++) {
    services[i]['_id'] = new ObjectId();
    services[i]['targetCode'] = 'T' + (i + 1);
    services[i]['formCode'] = 'F' + (i + 1);

    for (var k = 0; k < services[i].subservices.length; k++) {
        services[i].subservices[k]['targetCode'] = services[i]['targetCode'] + '-' + (k + 1);
    }

    db.services.insert(services[i]);
}

// Создаем заявки
db.createCollection('claims');

var statuses = ['Новое', 'В работе', 'Выполнено'];

for (var i = 0; i < 99; i++) {
    var claim = {
        number: i + 1,
        createdAt: new Date(2017, 06, Math.ceil(Math.random() * 30)),
        status: statuses[Math.floor(Math.random() * statuses.length)],
        service: {
            '$ref': 'services',
            '$id': services[Math.floor(Math.random() * services.length)]._id
        },
        person: {
            '$ref': 'persons',
            '$id': persons[Math.floor(Math.random() * persons.length)]._id
        },
        department: {
            '$ref': 'departments',
            '$id': departments[Math.floor(Math.random() * departments.length)]._id
        }
    };

    db.claims.insert(claim);
}
