function plus(a, b) {
    console.log(a + b);
}

function devide(aa, bb) {
    console.log(aa / bb);
}

plus(8, 60);
devide(8, 60);

const player = {
    name: "nao",
    sayHello: function(other){
        console.log("hello! " + other);
    }
};

console.log(player.name);
player.sayHello("didi");
