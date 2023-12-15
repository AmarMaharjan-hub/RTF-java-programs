const layout = [
    {
        type: "div",
        props: {
            id: "container",
        },
        children: [
            {
                type: "input",
                props: {
                    value: "foo",
                    type: "text"
                },
//                children:[]
            }
        ]
    },
    {
        type: "button",
        props: {
            id: "okButton",
        },
        children: [
            {
                type: "text",
                props: {
                    value: "Just"
                },
            }

        ]
    }
];
//const layout = {
//        type: "div",
//        props: {
//            id: "container",
//        },
//        children: [
//            {
//                type: "input",
//                props: {
//                    value: "foo",
//                    type: "text"
//                },
//                children:[]
//            }
//        ]
//    };
(() => {
    window.onload = init;
})();

var root;

function init(){
    var render = document.querySelector("#render");
    root = document.querySelector("#root");
//    console.log(root)
    render.addEventListener("click",() => renderElement(layout, root));
}

function renderElement(node, parent){
    Object.keys(node).forEach(element=>{
        const {type, props, children} = node[element];
//        const dom = document.createElement(type);
        console.log(type.localeCompare("text") == 0)
        const dom = type.localeCompare("text") == 0 ? document.createTextNode("") : document.createElement(type);

//        console.log(type);
        console.log(node[element]);
//        console.log("done");
        
        if(props != undefined){
            Object.keys(props).forEach(index =>{
                dom.setAttribute(index, props[index]);
            });
        }
        if(children != undefined){
            Object.keys(children).forEach(index => {
//                console.log(children[index])
//                console.log(dom)
//                renderElement(children[index], dom);
//                renderElement(index, dom);
                renderElement(children, dom);

               });

        }
//        console.log(parent , " " , dom)
//        console.log(dom)
        parent.appendChild(dom);
    });
}