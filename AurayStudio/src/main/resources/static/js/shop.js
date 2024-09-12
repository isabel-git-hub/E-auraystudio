 // 지도 초기화 (대전 위치로 설정)
        var map = L.map('map').setView([36.3504, 127.3845], 13); // 대전 중심 좌표

        // OSM 타일 레이어 추가
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);

       // 매장 데이터
        var stores = [
            { name: "A", lat: 36.3489, lng: 127.3833, description: "대전 A" },
            { name: "B", lat: 36.3489, lng: 127.3833, description: "대전 B" },
            { name: "C", lat: 36.3455, lng: 127.3870, description: "대전 C" },
            { name: "D", lat: 36.3565, lng: 127.3895, description: "대전 D" },
            { name: "E", lat: 36.3560, lng: 127.3905, description: "대전 E" },
            { name: "F", lat: 36.3470, lng: 127.3843, description: "대전 F" },
            { name: "G", lat: 36.3480, lng: 127.3820, description: "대전 G" },
            { name: "H", lat: 36.3600, lng: 127.3815, description: "대전 H" },
            { name: "I", lat: 36.3512, lng: 127.3882, description: "대전 I" },
            { name: "J", lat: 36.3535, lng: 127.3800, description: "대전 J" },
            { name: "K", lat: 36.3551, lng: 127.3845, description: "대전 K" },
            { name: "L", lat: 36.3595, lng: 127.3828, description: "대전 L" },
            { name: "M", lat: 36.3559, lng: 127.3869, description: "대전 M" },
            { name: "N", lat: 36.3500, lng: 127.3830, description: "대전 N" },
            { name: "O", lat: 36.3520, lng: 127.3910, description: "대전 O" },
            { name: "P", lat: 36.3538, lng: 127.3835, description: "대전 P" },
            { name: "Q", lat: 36.3570, lng: 127.3850, description: "대전 Q" },
            { name: "R", lat: 36.3540, lng: 127.3802, description: "대전 R" },
            { name: "S", lat: 36.3589, lng: 127.3839, description: "대전 S" },
            { name: "T", lat: 36.3529, lng: 127.3880, description: "대전 T" },
            { name: "U", lat: 36.3498, lng: 127.3818, description: "대전 U" },
            { name: "V", lat: 36.3502, lng: 127.3890, description: "대전 V" },
            { name: "W", lat: 36.3563, lng: 127.3863, description: "대전 W" },
            { name: "X", lat: 36.3525, lng: 127.3920, description: "대전 X" },
            { name: "Y", lat: 36.3509, lng: 127.3809, description: "대전 Y" },
            { name: "Z", lat: 36.3514, lng: 127.3885, description: "대전 Z" }
        ];
        
        // 매장마다 마커 추가
        stores.forEach(function(store) {
            var marker = L.marker([store.lat, store.lng]).bindPopup(`<b>${store.name}</b><br>${store.description}`);
            marker.addTo(map); // 지도에 마커 추가
        });

        // 검색 함수
        function searchStore() {
            var query = document.getElementById("searchInput").value.trim().toUpperCase();
            var results = stores.filter(store => store.name.toUpperCase().includes(query));
            var list = document.getElementById("storeList");
            list.innerHTML = ""; // 기존 검색 결과 초기화

            if (results.length === 0) {
                list.innerHTML = "<li>결과가 없습니다.</li>";
                return;
            }

            results.forEach(function(store) {
                var li = document.createElement("li");
                li.textContent = store.name + ": " + store.description;
                li.onclick = function() {
                    map.setView([store.lat, store.lng], 15); // 클릭 시 해당 매장으로 이동
                };
                list.appendChild(li);
            });
        }
        
        