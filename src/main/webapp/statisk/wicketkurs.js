    function changeTekst() {
        console.log("Her");
        var knapp = document.getElementById("visBlogginnleggKnapp");
        if (knapp.value == "Vis blogginnlegg") knapp.value = "Skjul blogginnlegg";
        else knapp.value = "Vis blogginnlegg";
    }
