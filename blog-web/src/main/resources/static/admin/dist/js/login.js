window.addEventListener("load", () => {
    "use strict";

    if (!CSS.supports("clip-path", "circle(120px at center)") && !CSS.supports("-webkit-clip-path", "circle(120px at center)")) {
        document.getElementById("stage").innerHTML = '<img src="../assets/screenshot-1.png">';
        return;
    }

    var apiPath = "https://live2d.fghrsh.net/api", state = 0,
        modelId = localStorage.getItem("modelId"),
        modelTexturesId = localStorage.getItem("modelTexturesId");
    if (modelId === null) {
        modelId = 1;
        modelTexturesId = 53;
    }
    loadModel(modelId, modelTexturesId);

    function loadModel(modelId, modelTexturesId) {
        localStorage.setItem("modelId", modelId);
        if (modelTexturesId === undefined) modelTexturesId = 0;
        localStorage.setItem("modelTexturesId", modelTexturesId);
        loadlive2d("live2d", `${apiPath}/get/?id=${modelId}-${modelTexturesId}`, null);
        console.log("live2d", `模型 ${modelId}-${modelTexturesId} 加载完成`);
        setTimeout(() => {
            coverPosition("80%");
            state = 2;
        }, 2000);
    }

    function loadRandModel() {
        var modelId = localStorage.getItem("modelId"),
            modelTexturesId = localStorage.getItem("modelTexturesId");
        fetch(`${apiPath}/rand_textures/?id=${modelId}-${modelTexturesId}`)
            .then(response => response.json())
            .then(result => {
                loadModel(modelId, result.textures.id);
                setTimeout(() => {
                    state = 2;
                    coverPosition("80%");
                    document.getElementById("refresh").setAttribute("href", "javascript:refresh()");
                }, 1000);
            });
    }

    function loadOtherModel() {
        var modelId = localStorage.getItem("modelId");
        fetch(`${apiPath}/switch/?id=${modelId}`)
            .then(response => response.json())
            .then(result => {
                loadModel(result.model.id);
            });
    }

    function coverPosition(pos) {
        document.getElementById("cover").style.bottom = pos;
    }

    window.info = function () {
        fetch("https://v1.hitokoto.cn")
            .then(response => response.json())
            .then(result => {
                alert("「" + result.hitokoto + "」——" + result.from);
            });
    }

    window.refresh = function () {
        state = 0;
        coverPosition("10%");
        document.getElementById("refresh").setAttribute("href", "javascript:void(0)");
        setTimeout(loadRandModel, 1000);
    }

    document.getElementById("handle").addEventListener("click", () => {
        if (state === 1) {
            state = 2;
            coverPosition("80%");
        } else if (state === 2) {
            state = 1;
            coverPosition("20%");
        }
    });

    document.querySelector("input[type=password]").addEventListener("focus", () => {
        if (state === 2) {
            state = 1;
            coverPosition("20%");
        }
    });
    document.querySelector("input[type=password]").addEventListener("blur", () => {
        if (state === 1) {
            state = 2;
            coverPosition("80%");
        }
    });
});