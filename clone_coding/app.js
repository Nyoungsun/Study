// function plus(a, b) {
//     console.log(a + b);
// }

// function devide(aa, bb) {
//     console.log(aa / bb);
// }

// function mul() {
//     console.log(2 * 2);
// }

// plus(8, 60);
// devide(8, 60);
// mul();
// mul();
// mul();

// function add(a) {
//     console.log(a-5);
// }

// add(5, 10, 11, 12); //첫번째 인자만 받음

// const player = {
//     name: "nao",
//     sayHello: function(other){
//         console.log("hello! " + other);
//     }
// };

// console.log(player, console);
// player.name="voa";
// console.log(player);
// player.age = 88;
// console.log(player);
// console.log(player.name);
// player.sayHello("didi");

// const tobuy = ["A", "B", "C"];
// tobuy[2]="D";
// console.log(tobuy);
// tobuy.push("E");
// console.log(tobuy);

const calc = {
    add: function(a, b) {
        console.log('hi');
        return a+b;         // return하면 함수 종료
        console.log('bye');
    },

    sub: function(a,b) {
        return a-b;
    },

    div: function(a,b) {
        return a/b;
    },

    mul: function(a,b) {
        return a*b;
    },

    power: function(a,b) {
        return a**b;
    }
};

const add = calc.add(1,2);      // add에 console.log(a+b); 를 쓰게 되면 나머지들이 Nan이 된다
const sub = calc.sub(add,2);
const div =calc.div(sub,2);
const mul = calc.mul(div,2);
const power = calc.power(mul,2);

console.log(add, sub, div, mul, power);

// const age = 96;
// function cal(age){
//     return age + 2;
// }

// const age2 = cal(age);
// console.log(age2);
