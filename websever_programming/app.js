var fs = require('fs');
var ejs = require('ejs');
var mysql = require('mysql');
var express = require('express');
var bodyParser = require('body-parser');
var cookieParser = require('cookie-parser');

var app = express();

var client = mysql.createConnection({
  user: 'root',
  password: '1234',
  database: 'aits'
});

app.use(cookieParser());
app.use(bodyParser.urlencoded({
  extended: false
}));


app.listen(80, function() {
  console.log('Server Running at http://localhost/');
});

//------------------------------로그인------------------------------------------
app.get('/', function(request, response) {
  fs.readFile('로그인.ejs', function(error, data) {
          response.end(data);
  });
});
app.post('/', function(request, response) {
  var id = request.body.id;
  var passwd = request.body.passwd;

  console.log(id, passwd);
  console.log(request.body);
  console.log(request.cookies);

  if(id == 'root' && passwd == '1234') {
    client.query('INSERT INTO passwd (id, passwd) VALUES (?, ?)', [id, passwd],
  function(){   response.cookie('auth', true);
    fs.readFile('로그인성공.html', function(error, data) {
      response.end(data);
    });
  });
  } else {
    fs.readFile('로그인실패.html', function(error, data) {
      response.end(data);
    });
  }
});


//------------------------------회원추가------------------------------------------
app.get('/add', function(request, response) {
  if (request.cookies.auth == 'true') {
    fs.readFile('회원추가.ejs', 'utf8', function(error, data) {
      response.end(data);
    });
  } else {
    fs.readFile('로그인확인.html', function(error, data) {
      response.end(data);
    });
  }
});
app.post('/add', function(request, response) {
  var body = request.body;
  client.query('INSERT INTO members (id, name, region) VALUES (?, ?, ?)', [
    body.id, body.name, body.region
  ], function() {
    response.redirect('/add');
  });
});

//------------------------------회원수정------------------------------------------
app.get('/edit', function(request, response) {
  if (request.cookies.auth == 'true') {
    fs.readFile('회원수정.ejs', 'utf8', function(error, data) {
      client.query('SELECT * FROM members', function(error, results) {
        response.end(ejs.render(data, {
          data: results
        }));
      });
    });
  } else {
    fs.readFile('로그인확인.html', function(error, data) {
      response.end(data);
    });
  }
});
app.post('/edit', function(request, response) {
  var body = request.body;
  client.query('UPDATE members SET name = ?, region = ? WHERE id = ?', [
    body.name, body.region, body.id
  ], function() {
    response.redirect('/edit');
  });
});

//------------------------------회원삭제------------------------------------------
app.get('/del', function(request, response) {
  if (request.cookies.auth == 'true') {
    fs.readFile('회원삭제.ejs', 'utf8', function(error, data) {
      client.query('SELECT * FROM members', function(error, results) {
        response.end(ejs.render(data, {
          data: results
        }));
      });
    });
  } else {
    fs.readFile('로그인확인.html', function(error, data) {
      response.end(data);
    });
  }
});
app.post('/del', function(request, response) {
  var body = request.body;
  client.query('DELETE FROM members WHERE id = ?', [
    body.id
  ], function() {
    response.redirect('/del');
  });
});

//------------------------------회원찾기------------------------------------------
app.get('/find', function(request, response) {
  if (request.cookies.auth == 'true') {
    fs.readFile('회원찾기.ejs', 'utf8', function(error, data) {
      client.query('SELECT * FROM members WHERE name = ?', function(error, results) {
        response.end(ejs.render(data, {
          data: results
        }));
      });
    });
  } else {
    fs.readFile('로그인확인.html', function(error, data) {
      response.end(data);
    });
  }
});
app.post('/find', function(request, response) {
  var body = request.body;
  fs.readFile('회원찾기.ejs', 'utf8', function(error, data) {
    client.query('SELECT * FROM members WHERE name = ?', [
      body.name
    ], function(error, results) {
      response.end(ejs.render(data, {
        data: results
      }));
    });
  });
});

//------------------------------회원명단------------------------------------------
app.get('/list', function(request, response) {
  if (request.cookies.auth == 'true') {
    fs.readFile('회원명단.ejs', 'utf8', function(error, data) {
      client.query('SELECT * FROM members', function(error, results) {
        response.end(ejs.render(data, {
          data: results
        }));
      });
    });
  } else {
    fs.readFile('로그인확인.html', function(error, data) {
      response.end(data);
    });
  }
});
